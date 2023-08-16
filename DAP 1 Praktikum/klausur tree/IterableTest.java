public class IterableTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        /*
         * The printData method is declared outside of the DoublyLinkedList and
         * BinarySearchTree classes.
         * The printData method can work with arguments from all classes that implement
         * the Iterable interface.
         * the type argument Integer is determined for F from printData( ints ),
         * – the type argument Student is determined for F from printData( students ).
         */
        /* */
        BinarySearchTree<Student> studentsTree = new BinarySearchTree<Student>();
        Student parent = new Student("E", "Inf", 10);
        Student child = new Student("G", "M", 15);
        studentsTree.add(parent);
        studentsTree.add(child);

        studentsTree.add(new Student("C", "Inf", 5));
        studentsTree.add(new Student("D", "Inf", 7));
        studentsTree.add(new Student("A", "Inf", 1));

        studentsTree.add(new Student("N", "M", 20));
        studentsTree.add(new Student("F", "M", 14));

        studentsTree.show();

        // Aufgabe 1
        System.out.println("1- countNodes(0, 5):" + studentsTree.countNodes(0, 5));

        // Aufgabe 2
        System.out.print("2- sortedup to 2");
        studentsTree.sortedUpto(2);

        // Aufgbe 3
        System.out.print("3- Largest in Level 3");
        System.out.println(studentsTree.largestTo(2).toString());

        // Aufgabe 4
        System.out.print("4- isNiceTree ");
        System.out.println(studentsTree.isNiceTree());
        // Aufgabe 5
        System.out.print("5- count nodes in unpair level ");
        System.out.println(studentsTree.countNodesImpair(0));
        // Aufgabe 6
        System.out.print("6- smaller than 5 exist ");
        System.out.println(studentsTree.smallerExist(new Student("a", "b", 5)));
        // aufgabe 7
        // System.out.print("7- sub tree 20 node ");
        // studentsTree.subTree(new Student("a", "b", 15)).show();
        // aufgabe 8
        System.out.print("8- isParent parent child ");
        System.out.println(studentsTree.isDirectParent(child, new Student("F", "M", 14)));

    }
}
