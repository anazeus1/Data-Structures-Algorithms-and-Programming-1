//Example of a strategy that can be used to determine the number of all students with 
//a matriculation number greater than 100 in a list of student objects.
public class CountStudentGt100Strategie extends DoubleLinkedList.InspectionStrategy {
    private int nbGt100;

    CountStudentGt100Strategie() {
        nbGt100 = 0;
    }

    public void inspect(Object ref) {
        Student student = (Student) ref;
        Student s = new Student("a", "a", 100);
        if (student.hasGreaterNumber(s)) {
            nbGt100 += 1;
        }
        ;

    }

    public int getNumberOfStudentgt100() {
        return nbGt100;
    }

}
