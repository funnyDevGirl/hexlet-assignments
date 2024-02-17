package exercise;

import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), SessionsController::show);

        // Отображение формы логина
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);

        // Процесс логина
        app.post(NamedRoutes.loginPath(), SessionsController::create);

        // Процесс выхода из аккаунта
        app.post(NamedRoutes.logoutPath(), SessionsController::delete);

        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
