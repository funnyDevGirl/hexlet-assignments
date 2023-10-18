package exercise;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testEnlargeWithoutElements() {
        String[][] image = new String[0][];
        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = new String[0][];
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlarge1() {
        String[][] image = {{"*", "*", "*"}, {"*", " ", "*"}, {"*", "*", "*"}};
        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = {{"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"}};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlarge2() {
        String[][] image = {{"*", "*", "*"}, {"*", " ", "*"}};
        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = {{"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"}};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlarge3() {
        String[][] image = {{"*"}, {" "}, {"*"}};
        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = {{"*", "*"},
                {"*", "*"},
                {" ", " "},
                {" ", " "},
                {"*", "*"},
                {"*", "*"}};
        assertThat(actual).isEqualTo(expected);
    }
}
// END
