package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.print("Вычисление окончено");
        }
    }
}
// END
