package exercise;

import org.apache.commons.lang3.StringUtils;

//import java.util.Arrays;
import java.util.List;


// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emailsList) {

        long countOfFreeDomains = emailsList.stream()
                .filter(email -> StringUtils.isNotBlank(email))
                .filter(email -> email.endsWith("@gmail.com") ||
                        email.endsWith("@yandex.ru") ||
                        email.endsWith("@hotmail.com"))
                .count();
        return countOfFreeDomains;
    }
}
// END
