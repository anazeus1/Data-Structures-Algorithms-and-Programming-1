public class Vorlesung {
    private String description;
    private Student[] students;
    private int firstUnused;

    public Vorlesung(String description, int limit) {
        this.description = description;
        this.students = new Student[limit];
        firstUnused = 0;
    }

    public boolean add(Student s) {

        if (firstUnused < students.length) {
            students[firstUnused] = s;
            firstUnused++;
            return true;
        }
        return false;

    }

    public void show() {
        System.out.println("lecture: " + description);
        System.out.println("participants: ");
        for (int i = 0; i < firstUnused; i++) {
            System.out.println(students[i]);
        }
    }

    public void selectionSortBynumber() {
        for (int i = 0; i < firstUnused - 1; i++) {
            int position = searchForMinimalNumber(i);
            swapPosition(i, position);
        }
    }

    public int searchForMinimalNumber(int start) {
        int selected = start;
        for (int i = start + 1; i < firstUnused; i++) {
            if (students[selected].hasGreaterNumber(students[i])) {
                selected = i;
            }
        }
        return selected;

    }

    public void swapPosition(int from, int to) {
        if (from != to) {
            Student temp = students[from];
            students[from] = students[to];
            students[to] = temp;
        }

    }

    public void insertionSortByNumber() {
        for (int i = 0; i < firstUnused; i++) {
            shiftStudentsByNumber(i);
        }
    }

    public void shiftStudentsByNumber(int start) {
        Student toInsert = students[start];
        int i = start;
        while (i > 0 && students[i - 1].hasGreaterNumber(toInsert)) {
            students[i] = students[i - 1];
            i--;
        }
        students[i] = toInsert;
    }

    // – decompose into subsequences using the pivot element
    private void groupBynumber(int leftBound, int rightBound) {

        // at least two elements must be sorted
        if (leftBound != rightBound) {

            int leftOfGreaterPart = leftBound;
            for (int candidate = leftBound; candidate < rightBound; candidate++)// we always start from the left of the
                                                                                // table;elements still have to be
                                                                                // distributed
            {
                if (students[rightBound].hasGreaterNumber(students[candidate]))// when the pivot(right bound) is bigger
                                                                               // then the candodate
                {
                    swapPosition(candidate, leftOfGreaterPart);// we swap the smaller element int the part smaller then
                                                               // the pivot
                    leftOfGreaterPart++;// the big part is less one element

                }
                swapPosition(rightBound, leftOfGreaterPart);// Pivot element is moved between the parts
            }
            groupBynumber(leftBound, leftOfGreaterPart - 1);// we do the algorithm again on the two halfes we ignore the
                                                            // pivot brcause he is already sorted
            groupBynumber(leftOfGreaterPart + 1, rightBound);

        }
    }
}
