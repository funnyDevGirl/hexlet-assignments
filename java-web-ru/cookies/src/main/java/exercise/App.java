package exercise;

import io.javalin.Javalin;
import exercise.controller.UsersController;
import exercise.util.NamedRoutes;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN

        //получаем форму для регистрации (на /users):
        app.get(NamedRoutes.buildUserPath(), UsersController::build);

        //сохраняем пользователя в репозиторий + redirect на его страницу:
        app.post(NamedRoutes.usersPath(), UsersController::save);

        // END

        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
