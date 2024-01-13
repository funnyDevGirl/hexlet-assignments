package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.print(Math.round(circle.getSquare()) + "\n");
            //System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.print("Не удалось посчитать площадь" + "\n");
            //System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.print("Вычисление окончено");
        }
    }
}
// END
