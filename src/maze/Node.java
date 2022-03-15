package maze;

import java.util.ArrayList;

public class Node extends Coordinate {

    private Node parent;

    private int heuristicCost;

    private int finalCost;

    private ArrayList<Node> neighbors;

    private boolean wall = false;
    private boolean path = false;

    public Node(int x, int y) {
        super(x, y);
        this.neighbors = new ArrayList<>();
    }


    public void addNeighbors(Node[][] grid) {
        int row = this.getX();
        int column = this.getY();

        if (row < grid.length - 1) {
            this.neighbors.add(grid[row + 1][column]);
        }
        if (row > 0) {
            this.neighbors.add(grid[row - 1][column]);
        }
        if (column < grid.length - 1) {
            this.neighbors.add(grid[row][column + 1]);
        }
        if (column > 0) {
            this.neighbors.add(grid[row][column - 1]);
        }
        if (row > 0 && column > 0) {
            this.neighbors.add(grid[row - 1][column - 1]);
        }
        if (row < grid[0].length - 1 && column > 0) {
            this.neighbors.add(grid[row + 1][column - 1]);
        }
        if (row > 0 && column < grid.length - 1) {
            this.neighbors.add(grid[row - 1][column + 1]);
        }
        if (row < grid[0].length - 1 && column < grid.length - 1) {
            this.neighbors.add(grid[row + 1][column + 1]);
        }
    }


    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getHeuristicCost() {
        return heuristicCost;
    }

    public void setHeuristicCost(int heuristicCost) {
        this.heuristicCost = heuristicCost;
    }

    public int getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(int finalCost) {
        this.finalCost = finalCost;
    }

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public void setPath(boolean path) {
        this.path = path;
    }

    @Override
    public String toString() {
        if (this.wall)
            return "*";
        if (this.path)
            return "P";
        return " ";
    }
}
