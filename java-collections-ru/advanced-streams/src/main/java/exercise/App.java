package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String data) {

        return Arrays.stream(data.split("\n"))
                .filter(h -> h.startsWith("environment"))
                .map(b -> b.replaceAll("environment=", "").replaceAll("\"", ""))
                .map(f -> f.split(","))
                .flatMap(a -> Arrays.stream(a))
                .filter(c -> c.startsWith("X_FORWARDED_"))
                .map(d -> d.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
