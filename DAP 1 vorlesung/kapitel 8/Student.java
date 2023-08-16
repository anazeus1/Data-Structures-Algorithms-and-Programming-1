public class Student extends Person {
    private String subject;
    private int id;

    public Student(String fi, String fa, String c, int y, String s, int id) {
        super(fi, fa, c, y);
        subject = s;
        this.id = id;
    }

    public String toString() {
        return super.toString() + " sub " + subject + " id " + id;

    }

    public boolean hasGreaterName(Student s) {
        return compareTo(s) > 0;
    }

    public boolean hasEqualName(Student s) {
        return compareTo(s) == 0;
    }

    public int getRegistrationNo() {
        return id;
    }

    public boolean isEqualTo(Student s) {
        return super.isEqualTo(s)
                && getRegistrationNo() == s.getRegistrationNo();
    }
    public void m(Person p) {
        System.out.println("student method person argument");

    }

    public void m(Student s) {
        System.out.println("student method Student argument");

    }

}
