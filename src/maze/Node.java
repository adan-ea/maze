package maze;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Node extends Coordinate implements Comparator<Node> {

    private Node parent;

    private int heuristicCost;

    private int finalCost;

    private int CurrentCost;

    private ArrayList<Node> neighbors;

    private boolean wall = false;
    private boolean path = false;

    public Node(int x, int y) {
        super(x, y);
        this.neighbors = new ArrayList<>();
    }


    public void  calculateHeuristic(Node finalNode){
        int heuristic = Math.abs(finalNode.getX() - getX() ) + Math.abs(finalNode.getY() - getY());
        this.setHeuristicCost(heuristic);
    }

    public void setWeight(Node currentNode, int cost){
        int currentCost = this.getCurrentCost() + cost;
        setParent(currentNode);
        setCurrentCost(currentCost);

    }

    public void calculateFinalCost(){
        int finalCost = this.getCurrentCost() + this.getHeuristicCost();
        setFinalCost(finalCost);
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

    public int getCurrentCost() {
        return CurrentCost;
    }

    public void setCurrentCost(int currentCost) {
        CurrentCost = currentCost;
    }

    public boolean isWall() {
        return wall;
    }

    public boolean isPath() {
        return path;
    }
    @Override
    public String toString() {
        if (this.wall)
            return "*";
        if (this.path)
            return "P";
        return " ";
    }


    @Override
    public boolean equals(Object o) {

        if(o == null){
            return false;
        }
        if(o.getClass() != this.getClass()){
            return false;
        }
        if( this == o ){
            return true;
        }
        Node other = (Node) o;
        return this.getX() == other.getX() && this.getY() == other.getY();
    }
    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.getFinalCost(), node2.getFinalCost());
    }
}
