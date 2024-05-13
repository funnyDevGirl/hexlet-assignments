package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread threadMax = new MaxThread(numbers);
        MinThread threadMin = new MinThread(numbers);

        Map<String, Integer> result = new HashMap<>();

        threadMax.start();
        LOGGER.info("INFO: Thread " + threadMax.getName() + " started");

        threadMin.start();
        LOGGER.info("INFO: Thread " + threadMin.getName() + " started");

        try {
            threadMin.join();
            //LOGGER.info("INFO: Thread " + threadMax.getName() + " finished");
            LOGGER.log(Level.INFO, "Thread " + threadMax.getName() + " finished");

            threadMax.join();
            //LOGGER.info("INFO: Thread " + threadMin.getName() + " finished");
            LOGGER.log(Level.INFO, "Thread " + threadMin.getName() + " finished");

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        result.put("min", threadMin.getMinNumber());
        result.put("max", threadMax.getMaxNumber());
        return result;
    }
    // END
}
