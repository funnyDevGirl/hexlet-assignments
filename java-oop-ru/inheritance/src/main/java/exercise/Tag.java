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
        /*StringBuilder result = new StringBuilder("<" + tagName + " ");
        for (Map.Entry<String, String> attribute : new LinkedHashMap<>(attributes).entrySet()) {
            result.append(attribute.getKey() + "=\"" + attribute.getValue() + "\" ");
        }
        result.deleteCharAt(result.length() - 1).append(">");
        return result.toString();*/

        return Stream.of("<", tagName).collect(Collectors.joining("")) +
                new LinkedHashMap<>(attributes).entrySet().stream()
                        .map(a -> (" " + a.getKey() + "=\"" + a.getValue() + "\""))
                        .collect(Collectors.joining("")) + ">";
    }
}
// BEGIN

// END
