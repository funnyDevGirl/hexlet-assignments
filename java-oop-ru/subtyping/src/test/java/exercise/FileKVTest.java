package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    private static Path filepath2 = Paths.get("src/test/resources/file3").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
        Files.writeString(filepath2, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void test1() {
        KeyValueStorage storage = new FileKV("src/test/resources/file2", Map.of("key", "value"));
        assertThat(storage.get("key2", "default")).isEqualTo("default");
        assertThat(storage.get("key", "default")).isEqualTo("value");

        storage.set("key2", "value2");
        storage.set("key", "value3");

        assertThat(storage.get("key2", "default")).isEqualTo("value2");
        assertThat(storage.get("key", "default")).isEqualTo("value3");

        storage.unset("key");
        assertThat(storage.get("key", "def")).isEqualTo("def");
        assertThat(storage.toMap()).isEqualTo(Map.of("key2", "value2"));

        String actual = Utils.serialize(storage.toMap());
        String expected = Utils.readFile("src/test/resources/file2");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test2() {

        String content = Utils.serialize(Map.of("key", "value"));
        Utils.writeFile("src/test/resources/file3", content);

        KeyValueStorage storage = new FileKV("src/test/resources/file2", Map.of("key", "value"));

        assertThat(storage.toMap()).isEqualTo(Utils.unserialize(Utils.readFile("src/test/resources/file3")));
        assertThat(Utils.serialize(storage.toMap())).isEqualTo(Utils.readFile("src/test/resources/file3"));
    }
    // END
}
