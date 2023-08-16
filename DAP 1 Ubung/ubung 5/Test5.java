public class Test5 {
    public static void main(String[] args) {

        LectureWithSortAlgorithms dap1 = new LectureWithSortAlgorithms(
                "dap1", 10);
        Student s1 = new Student("A", "Inf", 22);
        Student s2 = new Student("AB", "M", 2);
        Student s3 = new Student("AC", "DS", 32);
        Student s4 = new Student("AA", "DS", 42);
        Student s5 = new Student("A", "Inf", 322);
        Student s6 = new Student("AP", "Inf", 52);
        Student s8 = new Student("Aaz", "M", 221);
        Student s7 = new Student("AS", "Inf", 622);
        Student s9 = new Student("CVA", "M", 225);

        dap1.add(s9);
        dap1.add(s7);
        dap1.add(s8);
        dap1.add(s6);
        dap1.add(s5);
        dap1.add(s4);
        dap1.add(s3);
        dap1.add(s2);
        dap1.add(s1);
        dap1.groupBySubjekt(0, dap1.getFirstUnused() - 1);
        dap1.show();

        int[] t1 = { 7, 15, 3, 17, 19, 10, 5, 6, 11 };
        int[] t2 = { 3, 5, 6, 7, 10, 11, 15, 17, 19 };
        int[] t3 = { 19, 17, 15, 11, 10, 7, 6, 5, 3 };
        QuickSort a1 = new QuickSort(t1);
        QuickSort a2 = new QuickSort(t2);
        QuickSort a3 = new QuickSort(t3);
        a1.quickSort();
        a2.quickSort();
        a3.quickSort();

        int[] values = { 5, 3, 2, 4, 1, 0, };
        String b = addCalcExist(values, 0, 0, "");
        String reuslt = b.substring(1);
        System.out.println(reuslt);

        int[] containers = { 3, 7, 13, 2, 5, 5 };
        JavaStar ship = new JavaStar();
        boolean inBalance = ship.existsBalanceWith3Limited(containers, 16, 0, 0, 0, 0, 0, 2);
        System.out.println(inBalance);

        int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        BinarySearch binary = new BinarySearch();
        boolean found = binary.binarySearchRecursive(sorted, 9, 0, sorted.length - 1);
        System.out.println(found);
    }

    public static String addCalcExist(int[] value, int position, int result, String exp) {
        if (position == value.length) {
            if (result == 0) {
                return exp;

            }
            return " calculation impossible";

        }
        String a = addCalcExist(value, position + 1, result + value[position], exp + "+" + value[position]);
        if (a != "calculation impossible") {
            return a;
        }
        return addCalcExist(value, position + 1, result - value[position], exp + "-" + value[position]);

    }

}