//MOHEM jedda hedha lkol maj3oul bech nerta7ou mmin rab il typecasting belfalla9y hedhy (int)ref nerta7ou min rabha

import javax.swing.text.html.parser.Element;

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

    // aufgabe 3 s7i7a
    public int[] positions() {

        int total = 0;
        Element current = first;
        while (current != null) {
            if (current.getContent() == null) {
                total++;
            }
            current = current.getSucc();
        }
        int[] ints = new int[total];
        current = first;
        int i = 0;
        int j = 0;
        while (current != null) {
            if (current.getContent() == null) {
                ints[j] = i;
                j++;
            }
            current = current.getSucc();
            i++;

        }
        return ints;
    }

    // aufgabe 4
    public void appendFirst() {
        if (size >= 2) {
            Element oldFirst = first;
            first = oldFirst.getSucc();
            oldFirst.disconnectSucc();
            last.connectAsSucc(oldFirst);
            last = oldFirst;// nsina hedhy
        }
    }

    // augabe 5
    public void inject(DoublyLinkedList<T> into, int p) {
        Element current = first;
        int i = 0;
        if (p + 1 <= size() && into != null && !into.isEmpty()) {
            while (i < p) {

                i++;
                current = current.getSucc();
            }
            if (current == last) {
                last = into.last;

            } else {
                current.getSucc().connectAsPred(into.last);

            }
            current.connectAsSucc(into.first);
            size = size + into.size();
            into.first = into.last = null;
            into.size = 0;

        }

    }

    // aufgabe 6 s7i7a
    public boolean allEqual(DoublyLinkedList<T> d) {

        if (d.size() == size) {
            Element c1 = first;
            Element c2 = d.first;
            while (c1 != null) {
                if (c1.getContent() == null) {
                    if (c2.getContent() != null) {
                        return false;
                    }
                } else {
                    if (c2.getContent() == null) {
                        return false;
                    }
                    if (!c2.getContent().equals(c2.getContent())) {
                        return false;

                    }

                }
                c1 = c1.getSucc();
                c2 = c2.getSucc();

            }
            return true;
        } else {
            return false;
        }
    }

    // aufgabe 7
    public void moveToHead(int n) {

        if (n < size && n > 0) {
            int dif = size - n;
            Element current = first;
            while (dif > 0) {
                current = current.getSucc();
                dif--;
            }
            Element oldFirst = first;
            Element newLast = current.getPred();
            current.disconnectPred();
            first = current;
            last.connectAsSucc(oldFirst);
            last = newLast;

        }
    }

    // aufgabe 8
    public int strip() {

        Element current = first;
        int nb = 0;
        while (current != null) {
            if (current.getContent() == null) {
                nb++;
                if (current == first) {
                    first = first.getSucc();
                    current = first;
                    first.disconnectPred();

                } else if (current == last) {
                    last = last.getPred();
                    last.disconnectSucc();
                    current = null;
                } else {
                    current = current.getSucc();
                    current.getPred().getPred().connectAsSucc(current);

                }

            } else {
                current = current.getSucc();

            }
        }
        size = size - nb;
        return nb;

    }

    // aufgabe 9
    public boolean allIn(T[] test) {
        for (int i = 0; i < test.length; i++) {
            Element current = first;
            boolean contains = false;

            while (current != null) {
                if (current.getContent() != null) {
                    if (current.getContent().equals(test[i])) {
                        contains = true;

                    }
                }
                current = current.getSucc();
            }
            if (!contains) {
                return false;
            }

        }
        return true;
    }

    // aufgabe 10
    public void exchangeHalfs() {
        int i = 0;
        Element current = first;
        while (i < (size / 2 + size % 2)) {
            current = current.getSucc();
            i++;

        }
        Element newLast = current.getPred();
        current.getPred().disconnectSucc();
        last.connectAsSucc(first);
        first = current;
        last = newLast;
    }
    //aufgabe 11
    public void delete(T f1,T f2){
        /*int count = 0;
Element current = first;
while ( current != null )
{
if ( current.getContent() == null )
{
count++;
if ( first == last )
{
first = last = null;
}
else if ( current == first )
{
first = first.getSucc();
current = first;
first.disconnectPred();
}
else if ( current == last )
{
last = current.getPred();
last.disconnectSucc();
current = null;
}
else
{
current = current.getSucc();
current.getPred().getPred().connectAsSucc( current );
}
}
else
{
current = current.getSucc();
}
}
size = size - count;
 */
        Element current = first;
        while(current!=null){
            if(current.getContent()!=null && !current.getContent().equals(f1)){
                break;
            }
            current =current.getSucc();

        }
        
        if(current!=null){
            Element firstF1 =current;
            Element lastF2 =null;
           
            while(current!=null){
                if(current.getContent()!=null && current.getContent().equals(f2)){
                    lastF2 =current;

                }
                current =current.getSucc();
               

            }
            if(lastF2!= null){
            firstF1.disconnectSucc();
            lastF2.disconnectPred();
            firstF1.connectAsSucc(firstF1);}
        }

    }
}