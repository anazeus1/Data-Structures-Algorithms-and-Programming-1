public class Convert {
    public static void main(String[] args) {
        int a = 'c';
        int a1 = 1;
        // int a =1l wrong int a =1.0 wrong
        long b2 = 'c';
        long b = 6;
        long b1 = (int) 6L;
        // long b =2.0 wrong
        float c = 6L;
        float c1 = 5.1F;
        // float c = (double) 6; // float c =2.6 wrong
        double d = (float) 5;
        double d1 = 5.0;
        double d2 = a;// a from 99 to 99.0
        System.out.println(a + "+" + b1 + ";" + c + ";" + d2);
    }

}