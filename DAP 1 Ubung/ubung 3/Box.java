public class Box {
    private double hohe;
    private double breite;
    private double tiefe;

    public Box(double h, double b, double t) {
        if (h >= 0 && b >= 0 && t >= 0) {
            hohe = h;
            breite = b;
            tiefe = t;

        } else {
            hohe = 0;
            breite = 0;
            tiefe = 0;
        }

    }

    public double getbreite() {
        return breite;
    }

    public double gethohe() {
        return hohe;
    }

    public double gettiefe() {
        return tiefe;
    }

    public double getVolumeSize() {
        return breite * hohe * tiefe;
    }

    public double getAreaSize() {
        return 2 * (breite * hohe + breite * tiefe + hohe * tiefe);
    }

    public double getEdgesLength() {
        return 4 * (breite + hohe + tiefe);
    }

    public boolean isCube() {
        return (breite == hohe) && (breite == tiefe);
    }

    public int compareTo(Box f) {
        double v1 = getVolumeSize();
        double v2 = f.getVolumeSize();
        if (v1 > v2) {
            return 1;
        } else if (v1 == v2) {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean encloses(Box f) {
        // teste alle moeglichen Kombinationen
        return (breite >= f.breite && hohe >= f.hohe && tiefe >= f.tiefe)
                || (breite >= f.breite && hohe >= f.tiefe && tiefe >= f.hohe)
                || (breite >= f.hohe && hohe >= f.breite && tiefe >= f.tiefe)
                || (breite >= f.hohe && hohe >= f.tiefe && tiefe >= f.breite)
                || (breite >= f.tiefe && hohe >= f.breite && tiefe >= f.hohe)
                || (breite >= f.tiefe && hohe >= f.hohe && tiefe >= f.breite);
    }
}
