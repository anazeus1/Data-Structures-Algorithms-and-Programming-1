public class Student {
    private String name;
    private String subject;
    private int matrikelnummer;

    public Student(String name, String subject, int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
        this.name = name;
        this.subject = subject;

    }

    public String toString() {
        return "student: " + name + ", matrikelnumme: " + matrikelnummer + ", subject: " + subject;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;

    }

    public int getId() {
        return matrikelnummer;
    }

    public boolean hasGreaterNumber(Student s) {
        return getId() > s.getId();
    }

    public boolean hasEqualNumber(Student s) {
        return getId() == s.getId();

    }

    public boolean hasGreaterName(Student s) {
        return getName().compareTo(s.getName()) > 0;
    }

    public boolean hasEqualName(Student s) {
        return getName().compareTo(s.getName()) == 0;

    }

}
