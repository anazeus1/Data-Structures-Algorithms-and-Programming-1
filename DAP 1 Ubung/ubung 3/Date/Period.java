public class Period {
    private int minutes;

    public static void main(String[] args) {
        Period p1 = new Period(20, 3);
        int a = p1.getMinutes();
        int b = p1.getMinorMinutes();
        int c = p1.getHours();
        p1.change(500);
        System.out.println(p1.toString());

    }

    public Period(int m, int s) {
        if (m < 0 | s < 0) {
            minutes = 0;
        } else {
            minutes = m + s * 60;

        }

    }

    public Period(int m) {
        if (m < 0) {
            minutes = 0;
        } else {
            minutes = m;

        }

    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return minutes / 60;
    }

    public int getMinorMinutes() {
        return minutes % 60;
    }

    public String toString() {
        String stunde, minute;
        int h = getHours();
        if (h < 10) {
            stunde = "0";

        } else {
            stunde = "";
        }
        int m = getMinorMinutes();

        if (m < 10) {
            minute = "0";
        }

        else {
            minute = "";

        }
        return stunde + h + ":" + minute + m;
    }

    public Period clone() {
        return new Period(minutes);

    }

    public void change(int a) {
        if (a > 0) {
            minutes = minutes + a;

        }
    }
}
