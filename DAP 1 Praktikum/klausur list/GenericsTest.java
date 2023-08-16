public class GenericsTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        /* paramatische klasse */DoublyLinkedList<Integer> ints = new DoublyLinkedList<Integer>();

        /*
         * doublyLinkedList<Double> doubles = new DoublyLinkedList<>()
         * the <> tranfers the type no problem
         */

        /*
         * DoublyLinkedList doubles = new DoublyLinkedList();this raw type In this case,
         * no type cast operators are generated
         * it is better to not use this
         */
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);

        System.out.println("initial ints :");
        // aufgabe 4
        ints.appendFirst();
        System.out.println("4-append first to end :");
        ints.showAll();
        // aufgabe 5
        DoublyLinkedList<Integer> into = new DoublyLinkedList<Integer>();
        into.add(22);
        into.add(55);

        ints.inject(into, 2);
        System.out.println("5-inject 22, 55 after position 2 in ints :");
        ints.showAll();
        // aufgabe 7
        ints.moveToHead(2);
        System.out.println("7-move last 2 to beginning :");
        ints.showAll();
        // augabe 8
        ints.add(null);

        ints.add(null);
        ints.strip();
        System.out.println("8-strip nulls :");

        ints.showAll();
        // aufgabe 9
        Integer[] test = { 5, 6 };
        System.out.println("9-all in for 5,6 :" + ints.allIn(test));
        // aufgabe 9
        System.out.println("10-exchange halfs");
        ints.exchangeHalfs();
        ints.showAll();

    }
}
