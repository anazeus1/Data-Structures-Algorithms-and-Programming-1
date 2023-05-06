
public class PoinInTime {
    private int hour;
    private int day;
    private int year;

    public PoinInTime(int y, int t, int h) {
        if (y > 999 & y < 10000 & t > 0 & h > 0) {
            hour = h % 24;
            day = (t + h / 24) % 365;
            year = y + day / 365;
            if (year < 999 | year > 10000) {
                throw new IllegalArgumentException();

            }

        } else {
            throw new IllegalArgumentException();
        }

    }

    public String toString() {
        return (year + "/" + day + "/" + hour);
    }

    public PoinInTime clone() {
        return new PoinInTime(year, day, hour);
    }

    public PoinInTime change(int h) {
        if (h < 0) {
            if (year * 365 * 24 + day * 24 + hour > h) {
                return new PoinInTime(year, day, hour + h);

            }
            return new PoinInTime(year, day, hour);

        }
        return new PoinInTime(year, day, hour + h);
    }

}
