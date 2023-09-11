package exercise;

import java.util.Arrays;
//import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String text) {
        String[] arrayWithSymbols = symbols.split("");
        List<String> listWithSymbols = Arrays.asList(arrayWithSymbols);
        String[] arrayWithWord = text.split("");
        List<String> listWithWord = Arrays.asList(arrayWithWord);

        if (listWithSymbols.isEmpty() || listWithSymbols.size() < listWithWord.size()) {
            return false;
        }

        if (listWithSymbols.size() >= listWithWord.size()) {
            for (String word : listWithWord) {
                for (String symbol : listWithSymbols) {

                    boolean ans = symbol.equalsIgnoreCase(word);
                    if (ans) {
                        listWithSymbols.remove(word);
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
