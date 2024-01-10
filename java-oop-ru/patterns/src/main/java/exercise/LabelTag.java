package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String submit;
    private TagInterface tag;

    public LabelTag(String submit, TagInterface tag) {
        this.submit = submit;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" +
                submit +
                tag.render() +
                "</label>";
    }
}
// END
