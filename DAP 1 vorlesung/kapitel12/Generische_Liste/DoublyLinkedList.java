//MOHEM jedda hedha lkol maj3oul bech nerta7ou mmin rab il typecasting belfalla9y hedhy (int)ref nerta7ou min rabha

public class DoublyLinkedList<T/* type paramater */> // generic class
{
    private Element first, last;
    private int size;

    public DoublyLinkedList() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T content) // T instead of object
    {
        Element e = new Element(content);
        if (isEmpty()) {
            first = last = e;
        } else {
            last.connectAsSucc(e);
            last = e;
        }
        size++;
    }

    public void addFirst(T content) {
        Element e = new Element(content);
        if (isEmpty()) {
            first = last = e;
        } else {
            first.connectAsPred(e);
            first = e;
        }
        size++;
    }

    public T getFirst() {
        if (!isEmpty()) {
            return first.getContent();// getcontent return T instead of object
        } else {
            throw new IllegalStateException();
        }
    }

    public T get(int index) {
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

    public T removeFirst() {
        if (!isEmpty()) {
            T result = first.getContent();
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
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

    // Iterator

    public Iterator<T> iterator()// same argument paramater as upper class
    {
        return new ForwardIterator();
    }

    private abstract class ListIterator
            /* ListIterator without type parameters since T in (instance) class visible */ extends Iterator<T>/*
                                                                                                               * same
                                                                                                               * type
                                                                                                               * argument
                                                                                                               * as
                                                                                                               * extern
                                                                                                               * class
                                                                                                               */ {
        Element current;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (hasNext()) {
                T content = current.getContent();
                current = step();
                return content;
            } else {
                throw new IllegalStateException();
            }
        }

        abstract Element step();

    }

    private class ForwardIterator extends ListIterator {
        public ForwardIterator() {
            current = first;
        }

        Element step() {
            return current.getSucc();
        }
    }

    // strategies
    /*
     * To ensure type safety, SubstitutionStrategy must be declared as a generic
     * class
     */

    public static abstract class SubstitutionStrategy<E> /* type parameter E */ {
        public abstract E substitute(E ref);
    }

    public void substituteAll(SubstitutionStrategy<T> s) /*
                                                          * Type argument T guarantees compatibility with the executing
                                                          * object
                                                          */ {
        Element current = first;
        while (current != null) {
            current.setContent(s.substitute(current.getContent()));
            current = current.getSucc();
        }
    }

    public static abstract class InspectionStrategy<E> {
        public abstract void inspect(E ref);
    }

    public void inspectAll(InspectionStrategy<T> s) {
        Element current = first;
        while (current != null) {
            s.inspect(current.getContent());
            current = current.getSucc();
        }
    }

    public static abstract class DeletionStrategy<E> {
        public abstract boolean select(E ref);
    }

    public void deleteSelected(DeletionStrategy<T> s) {
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
            if (e.hasSucc() && e.hasPred()) {
                e.getPred().connectAsSucc(e.getSucc());
            } else if (e == first && e.hasSucc()) {
                first = first.getSucc();
                first.disconnectPred();
            } else if (e == last && e.hasPred()) {
                last = last.getPred();
                last.disconnectSucc();
            } else {
                first = last = null;
            }
            size--;
        }
    }

    // Element

    private class Element {
        private T content;
        private Element pred, succ;

        public Element(T c) {
            content = c;
            pred = succ = null;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T c) {
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

        public void connectAsSucc(Element e) {
            disconnectSucc();
            if (e != null) {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
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

        public void connectAsPred(Element e) {
            disconnectPred();
            if (e != null) {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }
    }

}
