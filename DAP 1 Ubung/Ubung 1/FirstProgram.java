public class FirstProgram {
    public static void main(String[] arg) {
        int[] values1 = { 1, 2, 3 };
        int[] values2 = { 4, 5, 6 };
        values1 = values2;
        System.out.println("hello world");
        System.out.println(Average(1, 21));
    }

    public static int Average(int value1, int value2) {
        return (value1 + value2) / 2;
    }

}