package exercise;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;


class AppTest {

    private static String expectedInput;
    private static String expectedLabel;

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedInput = readFixture("input.html");
        expectedLabel = readFixture("label.html");
    }

    @Test
    void testInput()  {
        TagInterface inputTag = new InputTag("submit", "Save");
        var actual = inputTag.render();

        assertThat(actual).isEqualTo(expectedInput);
    }

    @Test
    void testLabel()  {
        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", inputTag);
        var actual = labelTag.render();

        assertThat(actual).isEqualTo(expectedLabel);
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
            .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }
}
