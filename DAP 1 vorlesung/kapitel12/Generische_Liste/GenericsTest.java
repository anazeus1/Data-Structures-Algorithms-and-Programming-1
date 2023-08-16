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
        ints.showAll();
        System.out.println();
        Iterator<Integer> i = ints.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");// no type casting because naxt() returns double
        }
        System.out.println();
        DoublyLinkedList<Double> doubles = new DoublyLinkedList<Double>();
        /*
         * not possible doubles.add(content:14) because integer and duble not compatible
         * but possible if DoublyLinkedList<Number> doubles = new
         * DoublyLinkedList<Number>();
         * doubles.add(content:14);doubles.add(14.1);
         * and Iterator needs to be Iterator<Number>
         */

        /*
         * Die Klasse Number ist die Oberklasse der Klasse Integer.
         * DoublyLinkedList<Number> ist aber nicht
         * die Oberklasse von DoublyLinkedList<Integer>.
         * Beide Klassen sind vielmehr parametrisierte Versionen der gleichen
         * generischen Klasse
         * example:
         * DoublyLinkedList<Number> x;
         * x = new DoublyLinkedList<Integer>(); Error
         * x.add( 3.8 );
         */
        doubles.add(14.1);
        doubles.add(7.4);
        doubles.add(2.3);
        doubles.add(5.0);
        Iterator<Double> it = doubles.iterator();// iterator returns double
        double sum = 0.0;
        while (it.hasNext()) {
            sum += it.next();// no type casting because naxt() returns double
        }
        System.out.println("sum: " + sum);

        // ddouble int
        DoubleIntegersStrategy manip = new DoubleIntegersStrategy();
        ints.substituteAll(manip);
        ints.showAll();

    }
}
