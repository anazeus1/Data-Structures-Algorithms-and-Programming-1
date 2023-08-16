import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.text.Position;

public class HashTable<T> {
    LinkedList<T>[] table;// ein feld von listen als tabelle
    int capacity;// capacity of hashatable
    int size;// number of elements in it

    @SuppressWarnings({ "unchecked" })
    public HashTable(int c) {
        if (c > 0) {
            capacity = c;
        } else {
            throw new IllegalStateException();
        }
        table = new LinkedList[capacity];// NO type-safe generation is possible here there is a warining
        size = 0;
        for (int i = 0; i < capacity; i++) { /*
                                              * für jedes Element des Feldes muss
                                              * eine eigene Liste erzeugt werden
                                              */
            table[i] = new LinkedList<>();
        }

    }

    private int position(T o) {
        return Math.abs(o.hashCode() % capacity);
    }

    public boolean contains(T o) {
        return table[position(o)].contains(o);
    }

    public void put(T o) {
        if (!table[position(o)].contains(o)) {
            if ((double) (size + 1) / capacity > 0.75) {/* Reorganization necessary */
                rehash();
            }
            table[position(o)].add(o);
            size++;
        }
    }

    public void remove(T o) {/* remove returns true if o was included */
        if (table[position(o)].remove(o)) {
            size--;
        }
    }

    @SuppressWarnings({ "unchecked" })
    void rehash() {
        capacity = 2 * capacity;
        LinkedList<T>[] oldTable = table;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
        for (LinkedList<T> list : oldTable) {
            for (T elem : list) {
                if (elem != null) {
                    put(elem);
                }
            }
        }
    }
    /*
     * Feld-Attribut ist eine Referenz
     * neue Kapazität wird festgelegt
     * größeres Feld wird initialisiert
     * size wird durch put erhöht
     * Die Reorganisation muss über
     * put erfolgen, damit die größere
     * Kapazität bei der Verteilung der
     * Objekte auch genutzt wird
     */

}
