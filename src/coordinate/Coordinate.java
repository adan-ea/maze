package coordinate;

public class Coordinate {
    private int x;
    private int y;
    private Coordinate parent;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.parent = null;
    }

    Coordinate(int x, int y, Coordinate parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate getParent() {
        return parent;
    }

    public void setParent(Coordinate parent) {
        this.parent = parent;
    }
}
