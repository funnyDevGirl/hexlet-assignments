package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {

            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            ctx.json(
                    USERS.stream()
                            .skip((long) Math.max(page - 1, 0) * per)
                            .limit(per)
                            .toList()
            );

            //2 вариант:
//            var startIndex = per * (page - 1);
//            //на случай, если останется меньше минимального кол-ва элементов, исп-ем Math.min():
//            var endIndex = Math.min(startIndex + per, USERS.size());
//
//            ctx.json(USERS.subList(startIndex, endIndex));
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
