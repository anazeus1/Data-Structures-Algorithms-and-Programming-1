package kapitel9;


public class DoubleLinkedList {
    private Element first, last;
    private int size;

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
        return new ForwardIterator(first);// Run starts at first
    }

    public ReverseIterator reverseIterator() {
        return new ReverseIterator(last);// Run starts at last
    }
}
