public class Date {
  
    private String description;
    private Period period;
    private PoinInTime poinInTime;

    public Date(String d, Period p, PoinInTime t) {
        description = d;
        period = p;
        poinInTime = t;

    }

    public Date(String d) {
        description = d;
        period = null;
        poinInTime = null;
    }

    public String getDescription() {
        return description;
    }

    public Period getPeriod() {
        return period;
    }

    public PoinInTime getPointInTime() {
        return poinInTime;
    }

    public Date clone() {
        return new Date(description, period.clone(), poinInTime.clone());
    }

    public void set(Period p, PoinInTime t) {
        period = p;
        poinInTime = t;
    }

    public void change(int h) {
        if (poinInTime != null) {
            PoinInTime a = poinInTime.change(h);
            poinInTime = a;

        }
    }

    public String toString() {
        return "name: " + description + " date: " + poinInTime.toString() + " period: " + period.toString();
    }
}
