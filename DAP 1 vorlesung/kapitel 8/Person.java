public class Person {
    private String firstName;
    private String familyName;
    private String cityOfResidence;
    private int yearOfBirth;

    public Person(String fi, String fa, String c, int y) {
        firstName = fi;
        familyName = fa;
        cityOfResidence = c;
        yearOfBirth = y;
    }

    public String toString() {
        return "family name: " + familyName + ", first name: " + firstName +
                ", born in " + yearOfBirth + ", living in: " + cityOfResidence;
    }

    public boolean isEqualTo(Person p) {
        return (familyName.compareTo(p.familyName) == 0)
                && (firstName.compareTo(p.firstName) == 0)
                && yearOfBirth == p.yearOfBirth;
    }

    public int compareTo(Person p) {
        int compFamilyName = familyName.compareTo(p.familyName);
        if (compFamilyName != 0) {
            return compFamilyName;
        } else {
            return firstName.compareTo(p.firstName);
        }
    }

    public void m(Person p) {
        System.out.println("person method person argument");

    }

    public void m(Student s) {
        System.out.println("person method Student argument");

    }

}