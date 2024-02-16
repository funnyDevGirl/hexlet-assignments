package exercise.controller;

import java.util.Collections;

import java.util.stream.Collectors;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;

public class PostsController {

    // BEGIN

    //контроллер для рендера страницы конкретного поста:
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        //если поста не существует:
        if (PostRepository.find(id).isEmpty()) {
            ctx.status(404).result("age not found");
        } else {
            //показывает страницу поста:
            var post = PostRepository.find(id).get();
            var page = new PostPage(post);
            ctx.render("posts/show.jte", Collections.singletonMap("page", page));
        }
    }

    //контроллер для рендера страницы всех постов
    //с учетом номера страницы для навигации:
    public static void index(Context ctx) {

        //номер страницы:
        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        //кол-во постов на странице:
        int per = 5;

        page = page == 0 ? 1 : page;

        //выдача по 5 постов на странице:
        var posts = PostRepository.getEntities()
                .stream()
                .skip((long) Math.max(page - 1 , 0) * per)
                .limit(per)
                .collect(Collectors.toList());

        var postsPage = new PostsPage(posts, page);
        ctx.render("posts/index.jte", Collections.singletonMap("page", postsPage));
    }
    // END
}
