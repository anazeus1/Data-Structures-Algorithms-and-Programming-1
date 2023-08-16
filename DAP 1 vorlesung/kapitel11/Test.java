
public class Test {
    public static void main(String[] args) {
        DoubleLinkedList ints = new DoubleLinkedList();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        DoubleLinkedList students = new DoubleLinkedList();
        Student s = new Student("a", "a", 53);
        Student s1 = new Student("a", "b", 153);
        Student s2 = new Student("a", "c", 253);
        Student s3 = new Student("a", "d", 300);

        students.add(s);
        students.add(s1);
        students.add(s2);
        students.add(s3);

        // double ints
        DoubleIntergerStratgy manip = new DoubleIntergerStratgy();
        ints.subtituteAll(manip);
        ints.showAll();

        // increment by n

        AddNStrategy manip2 = new AddNStrategy(2);
        ints.subtituteAll(manip2);
        ints.showAll();

        // get sum
        IntegerSummationStrategy sumUp = new IntegerSummationStrategy();
        ints.inspectAll(sumUp);
        int a = sumUp.getSum();
        System.out.println(a);

        // determine the number of all students with
        // a matriculation number greater than 100

        CountStudentGt100Strategie nbGt100 = new CountStudentGt100Strategie();
        students.inspectAll(nbGt100);
        int b = nbGt100.getNumberOfStudentgt100();
        System.out.println(b);

        // delete even integers
        RemoveEvenIntegerStrategy manip3 = new RemoveEvenIntegerStrategy();
        ints.deleteSelected(manip3);
        ints.showAll();

    }

}
