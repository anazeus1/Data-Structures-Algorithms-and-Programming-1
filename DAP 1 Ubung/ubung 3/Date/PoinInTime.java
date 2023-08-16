
public class PoinInTime {
    private int hour;
    private int day;
    private int year;

    public PoinInTime(int y, int t, int h) {
        if (y > 999 && y < 10000 && t > 0 && t < 366 && h >= 0 && h < 24) {
            hour = h;
            day = t;
            year = y;

        } else {
            hour = 0;
            day = 0;
            year = 0;
        }

    }

    public String toString() {

        String d, h;
        if (day < 10) {
            d = "00" + day;

        } else if (day < 100) {
            d = "0" + day;
        } else {
            d = "" + day;
        }
        if (hour < 10) {
            h = "0" + hour;

        } else {
            h = "" + hour;
        }
        return (year + "/" + d + "/" + h);
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
