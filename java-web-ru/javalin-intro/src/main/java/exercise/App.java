package exercise;

// BEGIN
import io.javalin.Javalin;
// END


public final class App {

    public static Javalin getApp() {

        // BEGIN
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));

        // Возвращаем настроенное приложение
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
