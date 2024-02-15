package exercise.dto.articles;

import java.util.List;
import exercise.model.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticlesPage {
    private List<Article> articles;
}
