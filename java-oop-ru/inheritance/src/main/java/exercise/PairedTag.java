package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String bodyTag;
    List<Tag> childrens;

    public PairedTag(String tagName, Map<String, String> attributes, String bodyTag, List<Tag> childrens) {
        super(tagName, attributes);
        this.bodyTag = bodyTag;
        this.childrens = childrens;
    }

    @Override
    public String toString() {
        String child = childrens.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(""));

        return String.format("%s%s%s</%s>",
                toStringForSingleTag(), child, bodyTag, getTagName());
    }
}
// END