
public class DoubleLinkedList {
    private Element first, last;
    private int size;

    public static abstract class SubtituteStrategy {// The declaration is made as a public static inner class -
                                                    // public static, so that it can be subclassed outside
                                                    // of DoublyLinkedList without having to first create an object
                                                    // of DoublyLinkedList. static declaration necessary

        public abstract Object subtitute(Object ref);
    }

    public void subtituteAll(SubtituteStrategy s) {

        Element current = first;
        while (current != null) {
            current.setContent(s.subtitute(current.getContent()));// substitute returns an object that replaces
                                                                  // the contents of the list at the position of the
                                                                  // reference current.
            current = current.getSucc();
        }
    }
    // RABBKE IL DIFERENCE MABIN INSPECTION W SUBTITUE HYA IL SET CONTENT

    public static abstract class InspectionStrategy {// If only the content is to be considered - but not replaced -
                                                     // a constrained strategy avoids unintended replacements.{
        public abstract void inspect(Object ref);// The signature of the method inspect restricts the implementation:
                                                 // The parameter is a reference to Object, there is no return.
    }

    public void inspectAll(InspectionStrategy s) {// The inspectAll method calls an implementation of
                                                  // the inspect method for each item in the list, one at a time.
                                                  // The content of an element is passed to inspect as an argument.
                                                  // The method itself must store the result of the examination carried
                                                  // out in the inspect method in a suitable form in an object, for
                                                  // example in its strategy object
        Element current = first;
        while (current != null) {
            s.inspect(current.getContent());
            current = current.getSucc();
        }
    }

    public static abstract class DeletionStrategy {/*
                                                    * The abstract class DeletionStrategy specifies how to declare the
                                                    * methods that can be passed to the DoublyLinkedList class for
                                                    * execution.
                                                    * The signature of the select method returns a boolean
                                                    * value to the method that calls the select method.
                                                    * Based on the
                                                    * returned value, changes can now be made to the structure of the
                                                    * list.
                                                    */
        public abstract boolean select(Object ref);
    }

    public void deleteSelected(DeletionStrategy s) {/*
                                                     * The deleteSelected method checks all elements of the list by
                                                     * calling the select method.
                                                     * If select returns true for the content of an element, the element
                                                     * (and thus also the reference
                                                     * to the content) is deleted from the list.
                                                     * The method deleteSelected uses the private method remove, which
                                                     * deletes the
                                                     * element passed as an argument from the list.
                                                     */

        Element current = first;
        while (current != null) {
            Element candidate = current;
            current = current.getSucc();
            if (s.select(candidate.getContent())) {
                remove(candidate);
            }
        }
    }

    private void remove(Element e) {
        if (e != null) {
            if (e.hasSucc() && e.hasPred()) {// internal element
                e.getPred().connectAsSucc(e.getSucc());
            } else if (e == first && e.hasSucc()) {// first but not only element
                first = first.getSucc();
                first.disconnectPred();
            } else if (e == last && e.hasPred()) {// last but not only element
                last = last.getPred();
                last.disconnectSucc();
            } else {// only element
                first = last = null;
            }
            size--;
        }
    }

    private class Element /* the Element class can now also be hidden */ {
        private Object content;
        private Element pred, succ;

        public Element(Object c) {
            content = c;
            pred = succ = null;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object c) {
            content = c;
        }

        public boolean hasSucc() {
            return succ != null;
        }

        public Element getSucc() {
            return succ;
        }

        public void disconnectSucc() {

            if (hasSucc()) {
                succ.pred = null;
                succ = null;
            }
        }

        public boolean hasPred() {
            return pred != null;
        }

        public Element getPred() {
            return pred;
        }

        public void disconnectPred() {
            if (hasPred()) {
                pred.succ = null;
                pred = null;
            }
        }

        public void connectAsSucc(Element e) {
            disconnectSucc();
            if (e != null) {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }

        public void connectAsPred(Element e) {
            disconnectPred();
            if (e != null) {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }
    }

    public DoubleLinkedList() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object content) {
        Element e = new Element(content);
        if (isEmpty()) {
            first = last = e;
        } else {
            last.connectAsSucc(e);
            last = e;
        }
        size++;
    }

    public void addFirst(Object content) {
        Element e = new Element(content);
        if (isEmpty()) {
            first = last = e;
        } else {
            first.connectAsPred(e);
            first = e;
        }
        size++;

    }

    public Object getFirst() {
        if (!isEmpty()) {
            return first.getContent();
        } else {
            throw new IllegalStateException();
        }
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            Element current = first;
            for (int i = 0; i < index; i++) {
                current = current.getSucc();

            }
            return current.getContent();
        } else {
            throw new IllegalStateException();
        }

    }

    public Object removeFirst() {
        Object result = first.getContent();
        if (!isEmpty()) {
            if (first.hasSucc()) {
                first = first.getSucc();
                first.disconnectPred();
            } else {
                first = last = null;
            }
            size--;
            return result;
        } else {
            throw new IllegalStateException();
        }
    }

    public void showAll() {
        Element current = first;
        while (current != null) {
            System.out.print(current.getContent().toString());
            if (current != last) {
                System.out.print(" ,");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

}
