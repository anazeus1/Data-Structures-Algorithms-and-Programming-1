public class MultipleStrings {
    public static void main(String[] args) {
        MultipleStrings text = new MultipleStrings(5);
        text.addAtPosition("die stuhle liegen sehr eng oh", 0);
        text.addAtPosition("die stuhle liegen sehr eng ", 1);
        text.addAtPosition("die stuhle liegen sehr eng ohh", 2);
        text.addAtPosition("die stuhle liegen sehr eng ohhhoh", 3);
        text.addAtPosition("die stuhle liegen sehr eng", 4);
        text.atEnd("oh");

    }

    private String[] texts;

    public MultipleStrings(int n) {
        texts = new String[n];

    }

    public boolean addAtPosition(String s, int p) {
        if (p < 0 | p > texts.length) {
            return false;
        }
        texts[p] = s;
        return true;
    }

    public int size() {
        int a = 0;
        for (int i = 0; i < texts.length; i++) {
            if (texts[i] != null) {
                a++;
            }
        }
        return a;
    }

    public int atEnd(String end) {
        String endText;
        int endLength = end.length();
        int nbOccurs = 0;
        for (int i = 0; i < texts.length; i++) {
            if (texts[i] != null) {
                endText = texts[i].substring(texts[i].length() - endLength, texts[i].length());
                if (endText.equals(end)) {
                    nbOccurs++;

                }
            }

        }
        return nbOccurs;
    }

}