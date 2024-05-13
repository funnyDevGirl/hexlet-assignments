package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    private final int[] numbers;
    private int minNumber;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public void run() {
        minNumber = Arrays.stream(numbers).reduce(Integer.MAX_VALUE, Integer::min);
    }
}
// END
