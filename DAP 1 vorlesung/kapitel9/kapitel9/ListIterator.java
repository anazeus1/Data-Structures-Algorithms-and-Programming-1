package kapitel9;

/*
 * An abstract class is declared with the abstract modifier.
 * An abstract class is declared solely to serve as a superclass in inheritance
 * structures.
 * Objects of an abstract class cannot be created, the new operator cannot be
 * used (compiler error).
 * However, an abstract class can have constructors that can then be addressed
 * in the constructors of subclasses via super( ... ).
 * If an abstract class does not have a default constructor, the subclasses must
 * implement their own constructors.
 */
public abstract class ListIterator {
    Element current;// package acces

    public ListIterator(Element elem) {
        current = elem;
    }

    public boolean hasNext() {
        return current != null;
    }

    /*
     * Eine abstrakte Klasse kann – muss aber nicht – abstrakte Methoden besitzen.
     * Eine abstrakte Methode wird durch den Modifizierer abstract deklariert.
     * Eine abstrakte Methode besteht nur aus einer Signatur,die durch ;
     * abgeschlossen wird.
     * Eine abstrakte Methode stellt eine Vorgabe für ihre Unterklassen dar:
     * In Unterklassen müssen entweder
     * – alle abstrakten Methoden implementiert werden oder
     * – die Unterklasse muss auch wieder als abstrakte Klasse deklariert werden:
     * Dann wird eine Implementierung auf tiefer liegende Unterklassen verschoben.
     */
    public Object next() {
        if (hasNext()) {
            Object content = current.getContent();
            current = step();
            return content;
        } else {
            throw new IllegalStateException();

        }

    };

    abstract Element step();// no body needed
}
