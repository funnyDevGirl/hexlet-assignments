package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage();
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("name"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = Security.encrypt(ctx.formParam("password"));
        //Проверка имени и пароля:
        var user = UsersRepository.findByName(name);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                ctx.sessionAttribute("name", name);
                ctx.redirect(NamedRoutes.rootPath());
            }
            else {
                var page = new LoginPage(name, "Wrong username or password");
                ctx.render("build.jte", Collections.singletonMap("page", page));
            }
        }
        else {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
