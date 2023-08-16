public class DoubleLinkedList {
    private Element first, last;
    private int size;

    public abstract class ListIterator extends Iterator /* establishes type compatibility */ {
        Element current;// package acces

        public boolean hasNext() {
            return current != null;
        }

        public Object next() {
            if (hasNext()) {
                Object content = current.getContent();
                current = step();
                return content;
            } else {
                throw new IllegalStateException();

            }

        };

        // step in children
        abstract Element step();// no body needed
    }

    public class ForwardIterator extends ListIterator {
        private Element current;// Reference that marks the positio

        public ForwardIterator() {
            current = first;// The instance class ForwardIterator can access the (instance) attribute first
                            // of the enclosing class DoublyLinkedList.
        }

        Element step() {

            return current.getSucc();

        }

    }

    private class Element /*the Element class can now also be hidden*/{
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

    public ForwardIterator iterator() {
        return new ForwardIterator();// Run starts at first
    }

}
