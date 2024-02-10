package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/phones", ctx -> {
            // Получаем список телефонов:
            List<String> phones = Data.getPhones();
            ctx.json(phones);
        });

        app.get("/domains", ctx -> {
            // Получаем список доменных имен:
            List<String> domains = Data.getDomains();
            ctx.json(domains);
        });

        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
