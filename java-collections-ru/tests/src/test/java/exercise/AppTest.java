package exercise;

//import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake1() {
        // BEGIN
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int count = 6;

        List<Integer> expected = elements;
        List<Integer> actual = App.take(elements, count);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void testTake2() {

        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int count = 4;

        List<Integer> expected = elements;
        List<Integer> actual = App.take(elements, count);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void testTake3() {

        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int count = 2;

        List<Integer> expected = new ArrayList<>();
        expected.add(elements.get(0));
        expected.add(elements.get(1));
        List<Integer> actual = App.take(elements, count);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void testTake4() {

        List<Integer> elements = new ArrayList<>();
        int count = 2;

        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = App.take(elements, count);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void testTake5() {

        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int count = 0;

        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = App.take(elements, count);
        Assertions.assertEquals(actual, expected);
        // END
    }
}
