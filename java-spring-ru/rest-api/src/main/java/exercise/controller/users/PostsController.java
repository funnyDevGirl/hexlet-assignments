package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();


    //GET /api/users/{id}/posts — список всех постов, написанных пользователем с таким же userId, как id в маршруте
    //@RequestMapping("/api")
    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> index(@PathVariable int id) {
        var result = posts.stream()
                .filter(p -> p.getUserId() == id)
                .toList();
        return ResponseEntity.ok().body(result);
    }



    //POST /api/users/{id}/posts – создание нового поста, привязанного к пользователю по id.
    //Код должен возвращать статус 201, тело запроса должно содержать slug, title и body.
    //userId берется из маршрута
    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> create(@PathVariable int id, @RequestBody Post newPost) {
        newPost.setUserId(id);
        posts.add(newPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }
}
// END
