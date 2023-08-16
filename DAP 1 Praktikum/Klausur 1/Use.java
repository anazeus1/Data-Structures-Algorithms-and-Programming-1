public class Use {
    public static void main(String[] args) {
        Group g = new Group(3);
        Tuple t1 = new Tuple("t1", 1);
        Tuple t3 = new Tuple("t3", 3);
        g.insert(t3);
        g.insert(t1);
        Group g1 = extract(g, 3);
        int a = maxValue(g);

    }

    public static Group extract(Group g, int v) {
        Group g1 = g.copy();
        for (int i = 0; i < g.size(); i++) {
            Tuple t = g1.delete(i);

            if (t != null && t.getValue() < v) {
                g1.insert(t);
            }

        }
        return g1;
    }

    public static int maxValue(Group source) {
        Group g1 = source.copy();
        int max=null;
        for (int i = 0; i < source.size(); i++) {
            Tuple t = g1.delete(i);
            if (t != null && t.getValue() > max) {
                max = t.getValue();
            }

        }
        return max;
    }

}
