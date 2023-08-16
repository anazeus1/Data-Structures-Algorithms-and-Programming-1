public class HuffmanTriple {
    private char letter;
    private int frequency;
    private String coding;

    /*
     * Characters are first determined with their frequency. – The coding will be
     * determined later, so it cannot be set in the constructor
     */
    HuffmanTriple(char letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
        this.coding = "";

    }

    HuffmanTriple(char letter) {
        this(letter, 1);
    }

    HuffmanTriple() {
        this(' ', 0);
    }

    public int getFrequency() {
        return frequency;
    }

    public char getletter() {
        return letter;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;

    }

    public String toString() {
        return "token (quantity: " + frequency + "): " + letter + " -> code: " + coding;

    }

    public void incrementFrequency() {
        frequency++;
    }

    /* comparison by frequency value */
    public int compareTO(HuffmanTriple other) {
        return frequency - other.frequency;
    }
}