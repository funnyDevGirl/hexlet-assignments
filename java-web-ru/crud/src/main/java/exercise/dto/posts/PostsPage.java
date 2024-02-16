package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import exercise.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@Getter
@AllArgsConstructor
public class PostsPage {
    private List<Post> posts;
    private int page;

    public boolean hasNextPage() {
        return PostRepository.getEntities().size() > page * 5 ;
    }

    public boolean hasPreviousPage() {
        return this.page > 1;
    }

}
// END


