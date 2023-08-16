import java.text.Normalizer;

class Test {
    public static void main(String[] args) {
        All all = new Most();
        Most most = new Most();
        Normal normal = new Special();
        Special special = new Special();
        Top tm = new Middle();
        Upper um = new Middle();
        Middle mm = new Middle();
        Middle mb = new Bottom();

        tm.m(most);
        tm.m(special);
        um.m(normal);
        um.m(special);

        mm.m(normal);
        mm.m(special);

        mb.m(most);
        mb.m(normal);

    }
}
