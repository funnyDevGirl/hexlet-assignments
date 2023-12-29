package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    private static String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

    public static String getText() {
        return new StringBuilder(text).reverse().toString();
    }

    public int length() {
        return getText().length();
    }

    public char charAt(int index) {
        String text1 = getText();
        if (index < 0 || index > text1.length() - 1 || text1.equals("")) {
            return 0;
        }
        char[] symbols = text1.toCharArray();
        int i = index < symbols.length ? index : symbols.length - 1;

        return symbols[i];
    }

    public CharSequence subSequence(int start, int end) {
        String text1 = getText();

        if (start == end || end < start || start > text1.length()) {
            return "";
        }

        int endIndex = end > text1.length() ? text1.length() : end;

        if (start < endIndex && start >= 0 && endIndex <= text1.length()) {
            return text1.substring(start, endIndex);
        }
        return "";
    }

    @Override
    public String toString() {
        return getText();
    }

    /*@Override
    public String toString() {
        String text1 = getText();
        return "ReversedSequence{" +
                "text='" + text1 + '\'' +
                '}';
    }*/
// END
}