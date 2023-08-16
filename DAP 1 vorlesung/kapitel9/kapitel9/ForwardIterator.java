package kapitel9;

/*
Even a simple task like calculating the sum of all values ​​stored in a list of Integer objects has to be done via the very inefficient multiple calls of the get method, which starts a search from the beginning of the list with each call */
public class ForwardIterator extends ListIterator {
    private Element current;// Reference that marks the position

    public ForwardIterator(Element elem) {
        super(elem);// Constructor, takes reference to initial object as parameter
    }

    /*
     * public boolean hasNext() {
     * return current != null;
     * }not needed inhertited by list iterator
     */

    Element step() {

        return current.getSucc();

    }

}
