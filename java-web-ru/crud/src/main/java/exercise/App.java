package exercise;

import io.javalin.Javalin;
import exercise.controller.PostsController;
import exercise.controller.RootController;
import exercise.util.NamedRoutes;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get(NamedRoutes.rootPath(), RootController::index);

        // BEGIN

        //роутинг для просмотра списка всех постов:
        app.get(NamedRoutes.postsPath(), PostsController::index);

        //роутинг для просмотра конкретного поста:
        app.get(NamedRoutes.postPath("{id}"), PostsController::show);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
