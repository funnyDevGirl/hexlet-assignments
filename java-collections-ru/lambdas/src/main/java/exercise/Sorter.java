package exercise;

import java.util.Comparator;
//import java.util.Date;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        List<String> mans = users.stream()
                //отбираем всех мужчин:
                .filter(man -> man.get("gender").equals("male"))
                //сортировка по дате рождения:
                .sorted(Comparator.comparing(user -> LocalDate.parse(user.get("birthday"))))
                //отображаем только имена:
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
        return mans;
    }
}
// END
