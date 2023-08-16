package kapitel9;

public class ReverseIterator extends ListIterator {
    private Element current;

    public ReverseIterator(Element elem) {
        super(elem);
    }
    /*
     * public boolean hasNext() {
     * return current != null;
     * }not needed inhertited by list iterator
     */

    Element step() {
        return current.getPred();

    }
}
