package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String text1, String text2) {

        int text1Size = text1.length();
        int text2Size = text2.length();

        //список символов из слова:
        String[] text2Chars = text2.toLowerCase().split("");
        List<String> symbolsFromText2 = new ArrayList<>(Arrays.asList(text2Chars));

        //список символов из строки с буквами:
        String[] text1Chars = text1.split("");
        List<String> symbolsFromText1 = new ArrayList<>(Arrays.asList(text1Chars));

        //отсортированные списки:
        Collections.sort(symbolsFromText1);
        Collections.sort(symbolsFromText2);

        if (text1Size == 0 || text1Size < text2Size) {
            return false;
        }

        if (text1Size >= text2Size) {
            for (String symbol2 : symbolsFromText2) {
                if (!symbolsFromText1.contains(symbol2)) {
                    return false;
                }
                int index = symbolsFromText1.indexOf(symbol2);
                symbolsFromText1.remove(index);
            }
            return true;
        }
        return true;
    }
}
//END
