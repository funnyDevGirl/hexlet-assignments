package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import exercise.repository.ArticleRepository;
import exercise.model.Article;
import java.util.List;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    @BeforeAll
    public static void beforeAll() {
        app = App.getApp();
        app.start(0);
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }

    @AfterAll
    public static void afterAll() {
        app.stop();
    }

    @BeforeEach
    public void clear() {
        ArticleRepository.clear();
    }

    @Test
    void testRootPage() throws Exception {
        HttpResponse<String> response = Unirest.get(baseUrl + "/").asString();
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    void testListArticles() throws Exception {
        HttpResponse<String> response = Unirest.get(baseUrl + "/articles").asString();
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    void testNewArticlePage() throws Exception {
        HttpResponse<String> response = Unirest.get(baseUrl + "/articles/build").asString();
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    void testCreateArticlePositive() throws Exception {
        HttpResponse responsePost = Unirest
            .post(baseUrl + "/articles")
            .field("title", "test title")
            .field("content", "test content")
            .asEmpty();

        assertThat(responsePost.getStatus()).isEqualTo(302);
        assertThat(responsePost.getHeaders().getFirst("Location")).isEqualTo("/articles");

        HttpResponse<String> response = Unirest
            .get(baseUrl + "/articles")
            .asString();
        String body = response.getBody();
        assertThat(body).contains("test title");
        assertThat(body).contains("test content");

        // var article = ArticleRepository.findByTitle("test title");
        // assertThat(article, is(notNullValue()));
    }

    @Test
    void testCreateArticleNegative1() throws Exception {
        HttpResponse<String> responsePost = Unirest
            .post(baseUrl + "/articles")
            .field("title", "testTitle")
            .field("content", "testBody")
            .asString();

        assertThat(responsePost.getStatus()).isEqualTo(422);

        String body = responsePost.getBody();
        assertThat(body).contains("testTitle");
        assertThat(body).contains("testBody");
        assertThat(body).contains("Статья должна быть не короче 10 символов");

        // var article = ArticleRepository.findByTitle("test title");
        // assertNull(article);
    }

    @Test
    void testCreateArticleNegative2() throws Exception {
        HttpResponse<String> responsePost = Unirest
            .post(baseUrl + "/articles")
            .field("title", "q")
            .field("content", "test content")
            .asString();

        assertThat(responsePost.getStatus()).isEqualTo(422);

        String body = responsePost.getBody();
        assertThat(body).contains("q");
        assertThat(body).contains("test content");
        assertThat(body).contains("Название не должно быть короче двух символов");

        // var article = ArticleRepository.findByTitle("q");
        // assertNull(article);
    }

    @Test
    void testCreateArticleNegative3() throws Exception {
        HttpResponse<String> response1 = Unirest
            .post(baseUrl + "/articles")
            .field("title", "test article")
            .field("content", "test content")
            .asEmpty();

        assertThat(response1.getStatus()).isEqualTo(302);

        HttpResponse<String> response2 = Unirest
            .post(baseUrl + "/articles")
            .field("title", "test article")
            .field("content", "test content 2")
            .asString();

        assertThat(response2.getStatus()).isEqualTo(422);

        String body = response2.getBody();
        assertThat(body).contains("test article");
        assertThat(body).contains("test content 2");
        assertThat(body).contains("Статья с таким названием уже существует");

        List<Article> articles = ArticleRepository.search("test article");
        assertThat(articles.size()).isEqualTo(1);
    }
}
