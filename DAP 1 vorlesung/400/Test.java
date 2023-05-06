public class Test {
    public static void main(String[] args) {
        Vorlesung dap1 = new Vorlesung("Dap 1", 5);
        Student s1 = new Student("anas", "dap", 250);
        Student s2 = new Student("anas", "dap", 240);
        Student s3 = new Student("anas", "dap", 260);
        Student s4 = new Student("anass", "dap", 220);
        Student s5 = new Student("anas", "dap", 210);
        boolean a = s4.hasGreaterName(s5);
        System.out.println(a);
        dap1.add(s1);
        dap1.add(s2);
        dap1.add(s3);
        dap1.add(s4);
        dap1.add(s5);
        dap1.insertionSortByNumber();

        dap1.show();

    }

}
