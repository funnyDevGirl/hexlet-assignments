package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private final int[] numbers;
    private int maxNumber;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMaxNumber() {
        return maxNumber;
    }
    @Override
    public void run() {
        maxNumber = Arrays.stream(numbers).reduce(Integer.MIN_VALUE, Integer::max);
    }
}
// END
