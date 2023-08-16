public class Poly {
    public static void main(String[] args) {
        run();
    }

    public static void m(double p) {
        System.out.print("A ");
    }

    public static void m(int p) {
        System.out.print("L ");
    }

    public static void m(char p) {
        System.out.print("X ");
    }

    public static void run() {
        m('a');// char
        m(7 / 3.0);// double
        m('a' / 'b');// int
        m(new Integer(5));// int
        // m(float(3)) wrong if there is no vpid m(double p)
        // always go to the same type if not there go to parent
    }

}