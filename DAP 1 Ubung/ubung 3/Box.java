public class Box {
    private double hohe;
    private double breite;
    private double tiefe;

    public Box(double h, double b, double t) {
        hohe = h;
        breite = b;
        tiefe = t;

    }

    public double getHeight() {
        return hohe;
    }

    public double getwidth() {
        return breite;
    }

    public double getdeep() {
        return tiefe;
    }

    public double getVolumeSize() {
        return breite * tiefe * hohe;
    }

    public double getAreaSize() {
        return breite * hohe;

    }

    public double getEdgesLength() {
        return (breite + hohe + tiefe) * 4;
    }

    public boolean isCube() {
        return (hohe == breite) & (breite == tiefe);
    }

    public int compareTo(Box other) {
        double diff = getVolumeSize() - other.getVolumeSize();
        if (diff < 0) {
            return -1;
        }
        if (diff > 0) {
            return 1;
        }
        return 0;
    }

    public boolean enclose(Box other) {
        Box a = sortBox();
        Box b = other.sortBox();

        if (b.hohe <= a.hohe & b.tiefe <= a.tiefe & b.breite <= a.breite) {
            return true;
        }

        return false;
    }

    public Box sortBox() {
        if (hohe >= breite & hohe >= tiefe) {
            if (breite >= tiefe) {
                return new Box(hohe, breite, tiefe);
            }
            return new Box(hohe, tiefe, breite);
        }
        if (hohe <= tiefe & tiefe >= breite) {
            if (hohe >= breite) {
                return new Box(tiefe, hohe, breite);
            }
            return new Box(tiefe, breite, hohe);
        }
        if (breite >= hohe & breite >= tiefe) {
            if (tiefe >= hohe) {
                return new Box(breite, tiefe, hohe);
            }
        }
        return new Box(breite, hohe, tiefe);

    }
}
