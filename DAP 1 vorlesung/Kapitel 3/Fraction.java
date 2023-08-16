public class Fraction {
    public static void main(String[] args) {
        Fraction a = new Fraction(5, 1);
        Fraction b = new Fraction(15, 2);
        Fraction c = b.multiply(a);
        Fraction d = c.substract(a);
        Fraction e = d.divide(c);
        System.out.println(c.denominator);
        c.denominator = 5;
        System.out.println(c.denominator);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());

    }

    public int numenator;
    private int denominator;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int num) {
        this(num, 1);

    }

    public Fraction(int num, int denum) {
        if (denum != 0) {
            if (denum < 0) {
                denominator = -denum;
                numenator = -num;

            } else {
                numenator = num;
                denominator = denum;
            }
            reduce();

        }

        else {
            throw new IllegalArgumentException();
        }
    }

    private void reduce() {
        int gcd = findGcd();
        denominator = denominator / gcd;
        numenator = numenator / gcd;
    }

    private int findGcd() {
        int rest = 1;
        int divisor;
        int big;
        if (numenator < denominator) {
            divisor = Math.abs(numenator);
            big = denominator;
        } else {
            divisor = denominator;
            big = numenator;
        }
        while (rest != 0 & divisor != 0) {
            rest = big % divisor;

            big = divisor;
            divisor = rest;

        }
        return big;

    }

    public String toString() {
        return numenator + "/" + denominator;
    }

    public Fraction changeSign() {
        return new Fraction(-numenator, denominator);
    }

    public Fraction reverse() {
        return new Fraction(denominator, numenator);
    }

    public double toDouble() {
        return (double) numenator / (double) denominator;
    }

    public Fraction clone() {
        return new Fraction(numenator, denominator);
    }

    public boolean equals(Fraction other) {
        return (numenator == other.numenator) & (denominator == other.denominator);
    }

    public Fraction add(Fraction otherFraction) {
        int num = numenator * otherFraction.denominator + otherFraction.numenator * denominator;
        int denum = denominator * otherFraction.denominator;
        return new Fraction(num, denum);

    }

    public Fraction substract(Fraction other) {

        return add(other.changeSign());
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(numenator * other.numenator, denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        return multiply(other.reverse());
    }
}
