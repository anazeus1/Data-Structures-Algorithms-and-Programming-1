public class Test {
    public static void main(String[] args) {
        LectureWithSortAlgorithms dap1 = new LectureWithSortAlgorithms("dap 1", 9);
        Student s1 = new Student("domek", "dap 1", 0);
        Student s2 = new Student("6omek", "dap 1", 22);
        Student s3 = new Student("bomek", "dap 1", 73);
        Student s4 = new Student("aomek", "dap 1", 3);
        Student s5 = new Student("qomek", "dap 1", 5);
        Student s6 = new Student("(omek", "dap 1", 6);
        Student s7 = new Student("eomek", "dap 1", 4);
        Student s8 = new Student("somek", "dap 1", 11);
        Student s9 = new Student("mek", "dap 1", 20);
        dap1.add(s9);
        dap1.add(s8);
        dap1.add(s7);
        dap1.add(s6);
        dap1.add(s5);
        dap1.add(s4);
        dap1.add(s3);
        dap1.add(s2);
        dap1.add(s1);
        dap1.swapSortByName();
        ;
        dap1.show();

    }

}
