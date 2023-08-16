public class IterableTest {
    public static void main(String[] args) {
        test();
    }

    // printData outside of binarysearch tree and doublylinked list declared but can
    // be use by both
    public static <F> /* type parmeter for print data */void printData(Iterable<F> toIter)/*
                                                                                           * Methods can now also be
                                                                                           * declared that work on all
                                                                                           * data
                                                                                           * structures that implement
                                                                                           * the Iterable interface
                                                                                           */
    {
        Iterator<F> it = toIter.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void test() {
        /*
         * The printData method is declared outside of the DoublyLinkedList and BinarySearchTree classes. 
         *  The printData method can work with arguments from all classes that implement the Iterable interface. 
         * the type argument Integer is determined for F from printData( ints ), 
         * – the type argument Student is determined for F from printData( students ).
         */
        BinarySearchTree<Student> studentsTree = new BinarySearchTree<Student>();
        studentsTree.add(new Student("B", "Inf", 18));
        studentsTree.add(new Student("C", "M", 14));
        studentsTree.add(new Student("A", "Inf", 22));
        studentsTree.add(new Student("E", "M", 7));
        studentsTree.add(new Student("F", "Inf", 17));
        studentsTree.add(new Student("G", "M", 20));
        printData(studentsTree);
        System.out.println();
        DoublyLinkedList<Integer> intsList = new DoublyLinkedList<>();
        intsList.add(18);
        intsList.add(14);
        intsList.add(22);
        intsList.add(7);
        intsList.add(17);
        intsList.add(20);
        printData(intsList);
    }
}
