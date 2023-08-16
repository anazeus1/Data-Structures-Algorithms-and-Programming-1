public class Tuple {

    private String text;
    private int value;

    public Tuple(String t, int v) {
        text = t;
        value = v;
    }

    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int v) {
        value = v;
    }

}