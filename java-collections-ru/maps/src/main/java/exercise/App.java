package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {

        if (sentence.isEmpty()) {
            return new HashMap<>();
        }
        String[] words = sentence.trim().split(" ");

        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word: words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }
        return wordsCount;
    }

    public static String toString(Map wordsCount2) {

        var result = new StringBuilder();
        if (wordsCount2.isEmpty()) {
            return "{}";
        }
        result.append("{");
        for (Object key: wordsCount2.keySet()) {
            result.append("\n  " + key + ": " + wordsCount2.get(key));
        }
        result.append("\n}");
        return result.toString();
    }
}
//END
