package maze;

/**
 * The type Coordinate.
 */
public abstract class Coordinate {
    private int x, y;

    /**
     * Instantiates a new Coordinate.
     *
     * @param x the x
     * @param y the y
     */
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }
}
