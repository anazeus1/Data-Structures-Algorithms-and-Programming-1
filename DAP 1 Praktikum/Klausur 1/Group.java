public class Group {

    private Tuple[] map;

    public Group(int n) {
        map = new Tuple[n];
    }

    public int size() {
        return map.length;
    }

    public Tuple delete(int i) {
        Tuple result = null;
        if (i >= 0 && i < size()) {
            result = map[i];
            map[i] = null;
        }
        return result;
    }

    public Group copy() {
        Group into = new Group(map.length);
        for (int i = 0; i < map.length; i++) {
            into.map[i] = this.map[i];
        }
        return into;
    }

    public boolean insert(Tuple p) {

        for (int i = 0; i < map.length; i++) {
            if (map[i] == null) {
                map[i] = p;
                return true;
            }
        }
        return false;
    }
}
