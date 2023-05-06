
public class CalculateFraction {
    public static void main(String[] args) {
        Fraction a = new Fraction(5, 1);
        Fraction b = new Fraction(15, 2);
        Fraction c = b.multiply(a);
        Fraction d = c.substract(a);
        Fraction e = d.divide(c);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());

    }

}
