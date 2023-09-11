package exercise;

//import java.util.Arrays;
//import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(List<String> symbolList, String word) {
        String[] parts = word.split("");

        if (symbolList.isEmpty()) {
            return false;
        }

        if (symbolList.size() >= word.length()) {
            for (String part : parts) {
                for (String symbol : symbolList) {

                    boolean ans = symbol.equalsIgnoreCase(part);
                    if (ans) {
                        symbolList.remove(part);
                    }
                    else {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
//END
