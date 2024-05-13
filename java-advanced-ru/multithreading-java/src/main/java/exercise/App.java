package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread threadMax = new MaxThread(numbers);
        MinThread threadMin = new MinThread(numbers);

        Map<String, Integer> result = new HashMap<>();
        System.out.println("INFO: Thread " + threadMax.getName() + " started");
        threadMax.start();
        System.out.println("INFO: Thread " + threadMin.getName() + " started");
        threadMin.start();

        try {
            threadMin.join();
            threadMax.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("INFO: Thread " + threadMax.getName() + " finished");
        System.out.println("INFO: Thread " + threadMin.getName() + " finished");

        result.put("min", threadMin.getMinNumber());
        result.put("max", threadMax.getMaxNumber());
        return result;
    }
    // END
}
