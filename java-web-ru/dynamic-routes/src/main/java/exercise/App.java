package exercise;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {

            var id = ctx.pathParam("id");
            var company = companyFind(id);

            if (company != null) {
                ctx.json(company);
            } else {
                ctx.status(404).result("Company not found");
            }
            //Context context = company != null ? ctx.json(company) : ctx.status(404).result("Company not found");
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static Map<String, String> companyFind(String id) {
        for (var company : COMPANIES) {
            if (company.get("id").equals(id)) {
                return company;
            }
        }
        return null;
    }
}
