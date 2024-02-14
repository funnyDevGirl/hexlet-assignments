package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN

        app.get("/users", ctx -> {

            var term = ctx.queryParamAsClass("term", String.class).getOrDefault(null);
            var result = getUsersWithTerm(term);
            var page = new UsersPage(result, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
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

    public static List<User> getUsersWithTerm(String term) {
        if (term == null || term.isEmpty()) {
            // если параметр term не указан, возвращаем полный список пользователей
            return USERS;
        } else {
            // переводим в нижний регистр для поиска без учета регистра
            String searchTerm = term.toLowerCase();
            return USERS.stream()
                    .filter(user -> user.getFirstName()
                            .toLowerCase()
                            .startsWith(searchTerm))
                    .collect(Collectors.toList()); // фильтруем пользователей по началу имени без учета регистра
        }
    }
}
