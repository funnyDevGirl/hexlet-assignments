package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.stream.Stream;

public class Tag {
    String tagName;
    Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String getTagName() {
        return tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    protected String toStringForSingleTag() {

        String attr = attributes.entrySet().stream()
                .map(a -> String.format(" %s=\"%s\"", a.getKey(), a.getValue()))
                .collect(Collectors.joining(""));

        return String.format("<%s%s>", tagName, attr);
    }
}
// BEGIN

// END
