package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {

            var page = new UsersPage(USERS);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users/{id}", ctx -> {

            var id = ctx.pathParam("id");
            var user = findUser(id);

            if (user != null) {
                var page = new UserPage(user);
                ctx.render("users/show.jte", Collections.singletonMap("page", page));
            } else {
                ctx.status(404).result("User not found");
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static User findUser(String id) {
        for (var user : USERS) {
            if (String.valueOf(user.getId()).equals(id)) {
                return user;
            }
        }
        return null;
    }
}
