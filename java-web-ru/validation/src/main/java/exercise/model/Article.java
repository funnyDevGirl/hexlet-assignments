package exercise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class Article {

    private Long id;

    @ToString.Include
    private String title;

    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
