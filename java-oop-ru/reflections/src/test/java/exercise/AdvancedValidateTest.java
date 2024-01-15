package exercise;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AdvancedValidateTest {
    @Test
    void advancedTest1() {

        Address address2 = new Address(
                null,
                "London",
                "1-st street",
                null,
                "1");
        Map<String, List<String>> result2 = Validator.advancedValidate(address2);
        Map<String, List<String>> expected2 = Map.of(
                "country",
                List.of("can not be null", "length less than 10"),
                "houseNumber",
                List.of("can not be null"));
        assertThat(result2).isEqualTo(expected2);
    }
}
