package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
//import java.util.Map.Entry;

// BEGIN
class App {

    private static final List<Map<String, String>> BOOKS = List.of(
            Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611"),
            Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111"),
            Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611"),
            Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222"),
            Map.of("title", "Still foooing", "author", "FooBar", "year", "3333"),
            Map.of("title", "Happy Foo", "author", "FooBar", "year", "4444")
    );
    public static List<Map<String, String>> findWhere(List<Map<String, String>> BOOKS, Map<String, String> where) {

        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : BOOKS) {
            if (containsAllEntries(where, book)) {
                result.add(book);
            }
        }
        return result;
    }

    static boolean containsAllEntries(Map<String, String> where, Map<String, String> BOOKS) {
        return BOOKS.entrySet().containsAll(where.entrySet());
    }
}
//END
