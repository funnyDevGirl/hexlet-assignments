package exercise;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Iterator;
import java.util.List;
//import java.util.stream.Stream;

// BEGIN
class App {
    //во сколько раз увеличивается матрица:
    static int enlargement = 2;

    public static String[][] enlargeArrayImage(String[][] image) {
        int rows = image.length;

        if (rows == 0) {
            return new String[0][];
        }

        int columns = image[0].length;

        int enlargedRows = rows * enlargement;
        int enlargedColumns = columns * enlargement;

        String[][] enlargedImage = new String[enlargedRows][enlargedColumns];
        for (int i = 0; i < enlargedImage.length; i++) {
            for (int j = 0; j < enlargedImage[i].length; j++) {
                enlargedImage[i][j] = image[i / 2][j / 2];
            }
        }
        return enlargedImage;
    }
}
// END
