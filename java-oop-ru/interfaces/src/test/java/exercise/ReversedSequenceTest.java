package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReversedSequenceTest {

    @Test
    void getReverseTextTest1() {
        CharSequence text = new ReversedSequence("");
        String expected = "";
        String actual = ReversedSequence.getText();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getReverseTextTest2() {
        CharSequence text = new ReversedSequence("Alina");
        String expected = "anilA";
        String actual = ReversedSequence.getText();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void lengthTest1() {
        CharSequence text = new ReversedSequence("");
        int expected = 0;
        int actual = text.length();
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void lengthTest2() {
        CharSequence text = new ReversedSequence("Alina");
        int expected = 5;
        int actual = text.length();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void charAtTest1() {
        CharSequence text = new ReversedSequence("Alina");
        char expected = 'n';
        char actual = text.charAt(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void charAtTest2() {
        CharSequence text = new ReversedSequence("Alina");
        char expected = 0;
        char actual = text.charAt(10);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subSequenceTest1() {
        CharSequence text = new ReversedSequence("Alina");
        var expected = "ni";
        var actual = text.subSequence(1, 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subSequenceTest2() {
        CharSequence text = new ReversedSequence("Alina");
        var expected = "";
        var actual = text.subSequence(10, 3);
        assertThat(actual).isEqualTo(expected);
    }
}