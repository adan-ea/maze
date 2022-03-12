package maze;

public enum MazeElement {
    ROAD(0), WALL(1), START(2), EXIT(3), PATH(4);
    private int value;

    private MazeElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
