public class Polymorphie {
    public static void main(String[] args) {

        Person p = new Person("a", "a", "a", 0);
        Person s = new Student("b", "b", "c", 1, "b", 1);
        p.toString();// family name: a, first name: a, born in 0,
        s.toString();// family name: b, first name: b, born in 1, living in: c sub b id 1
        p.compareTo(s);// -1 no error
        s.compareTo(p);// 1 no error
        s.compareTo(s);// 0 no error

        Top t = new Top();
        Middle m = new Middle();
        Bottom b = new Bottom();
        Top tm = new Middle();
        Top tb = new Bottom();
        Middle mb = new Bottom();
        tm.m(t);// Top method Top arg
        tm.m(tb);// Top method Top arg
        tm.m(mb);// Top method Middle arg
        tm.m(b);// Top method Bottom arg
        tb.m(tm);// Top method top arg
        mb.m(t);// Middle Method top arg
        mb.m(m);// Middle Method top arg
    }

}
