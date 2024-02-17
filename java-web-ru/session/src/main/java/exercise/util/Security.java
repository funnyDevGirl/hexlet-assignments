package exercise.util;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class Security {
    public static String encrypt(String password) {
        var hashed = Hashing.sha256()
            .hashString(password, StandardCharsets.UTF_8)
            .toString();
        return hashed;
    }
}
