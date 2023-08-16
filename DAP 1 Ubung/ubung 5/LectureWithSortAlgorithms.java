public class LectureWithSortAlgorithms {
    private String title;
    private Student[] students;
    private int firstUnused;

    public LectureWithSortAlgorithms(String t, int cap) {
        title = t;
        students = new Student[cap];
        firstUnused = 0;
    }

    public void add(Student s) {
        if (firstUnused < students.length) {
            students[firstUnused] = s;
            firstUnused++;
        }
    }

    public void show() {
        System.out.println("lecture: " + title);
        System.out.println("participants:");
        for (Student s : students) {
            if (s != null) {
                System.out.println(s.toString());
            }
        }
    }

    private void swapStudents(int i, int j) {
        if (i != j) {
            Student temp = students[i];
            students[i] = students[j];
            students[j] = temp;
        }
    }

    public void insertionSortByNumber() {
        for (int i = 1; i < firstUnused; i++) {
            shiftStudentsByNumber(i);
        }
    }

    private void shiftStudentsByNumber(int start) {
        Student toInsert = students[start];
        int i = start;
        while (i > 0 && students[i - 1].hasGreaterNumber(toInsert)) {
            students[i] = students[i - 1];
            i--;
        }
        students[i] = toInsert;
    }

    public void insertionSortByName() {
        for (int i = 1; i < firstUnused; i++)
            shiftStudentsByName(i);
    }

    private void shiftStudentsByName(int start) {
        Student toInsert = students[start];
        int i = start;
        while (i > 0 && students[i - 1].hasGreaterName(toInsert)) {
            students[i] = students[i - 1];
            i--;
        }
        students[i] = toInsert;
    }

    public void selectionSortByName() {
        for (int i = 0; i < firstUnused - 1; i++) {
            int position = searchForMinimalName(i);
            swapStudents(i, position);
        }
    }

    private int searchForMinimalName(int start) {
        int selected = start;
        for (int i = start + 1; i < firstUnused; i++) {
            if (students[selected].hasGreaterName(students[i])) {
                selected = i;
            }
        }
        return selected;
    }

    public void selectionSortByNumber() {
        for (int i = 0; i < firstUnused - 1; i++) {
            int position = searchForMinimalNumber(i);
            swapStudents(i, position);
        }
    }

    private int searchForMinimalNumber(int start) {
        int selected = start;
        for (int i = start + 1; i < firstUnused; i++) {
            if (students[selected].hasGreaterNumber(students[i])) {
                selected = i;
            }
        }
        return selected;
    }

    public void quickSortByNumber() {
        groupByNumber(0, firstUnused - 1);
    }

    private void groupByNumber(int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int leftOfGreaterPart = leftBound;

            for (int candidate = leftBound; candidate < rightBound; candidate++) {
                if (students[rightBound].hasGreaterNumber(students[candidate])) {
                    swapStudents(candidate, leftOfGreaterPart);
                    leftOfGreaterPart++;
                }
            }

            swapStudents(leftOfGreaterPart, rightBound);

            groupByNumber(leftBound, leftOfGreaterPart - 1);
            groupByNumber(leftOfGreaterPart + 1, rightBound);
        }
    }

    public void quickSortByName() {
        groupByName(0, firstUnused - 1);
    }

    private void groupByName(int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int leftOfGreaterPart = leftBound;

            for (int candidate = leftBound; candidate < rightBound; candidate++) {
                if (students[rightBound].hasGreaterName(students[candidate])) {
                    swapStudents(candidate, leftOfGreaterPart);
                    leftOfGreaterPart++;
                }
            }

            swapStudents(leftOfGreaterPart, rightBound);

            groupByName(leftBound, leftOfGreaterPart - 1);
            groupByName(leftOfGreaterPart + 1, rightBound);
        }
    }

    public void groupBySubjekt(int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int leftOfMPart = leftBound;

            for (int candidate = leftBound; candidate < rightBound; candidate++) {
                if (students[candidate].getSubject().compareTo(students[rightBound].getSubject()) < 0) {
                    swapStudents(candidate, leftOfMPart);
                    leftOfMPart++;
                }

            }
            swapStudents(rightBound, leftOfMPart);
            groupBySubjekt(leftOfMPart + 1, rightBound);
            groupBySubjekt(leftBound, leftOfMPart - 1);

        }
    }

    public int getFirstUnused() {
        return firstUnused;
    }

    private void show(String explain, int low, int high) {
        System.out.println(explain + "( " + low + ", " + high + " )");
        for (int i = low; i <= high; i++) {
            System.out.println("  " + students[i].toString());
        }
        System.out.println();
    }

    // isSorted supports testing of sort algorithms; will be quiet without errors
    public void isSorted() {
        for (int i = 0; i < firstUnused - 1; i++) {
            if (students[i].hasGreaterNumber(students[i + 1])) {
                throw new RuntimeException("sort violation");
            }
        }
    }

}