package maze;

import java.util.ArrayList;
import java.util.Comparator;

public class Node extends Coordinate{

    private Node parent;

    private int heuristicCost, finalCost, currentCost;
    private boolean isFirst, isLast;

    private ArrayList<Node> neighbors;

    private boolean wall = false;
    private boolean path = false;

    public Node(int x, int y) {
        super(x, y);
        this.neighbors = new ArrayList<>();
    }

    public void calculateHeuristic(Node finalNode) {
        int heuristic = Math.abs(finalNode.getX() - getX()) + Math.abs(finalNode.getY() - getY());
        this.setHeuristicCost(heuristic);
    }

    public void setWeight(Node currentNode, int cost) {
        int currentCost = this.getCurrentCost() + cost;
        setParent(currentNode);
        setCurrentCost(currentCost);
        calculateFinalCost();

    }

    public boolean checkBetterPath(Node currentNode, int cost) {
        int currentCost = currentNode.getCurrentCost() + cost;
        if (currentCost < this.getCurrentCost()) {
            setWeight(currentNode, cost);
            return true;
        }
        return false;
    }

    public void calculateFinalCost() {
        int finalCost = this.getCurrentCost() + this.getHeuristicCost();
        setFinalCost(finalCost);
    }

    private Node checkNode(Node currentNode, int col, int row, int cost) {
        return null;
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

    public int getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(int currentCost) {
        this.currentCost = currentCost;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public boolean isPath() {
        return path;
    }

    public void setPath(boolean path) {
        this.path = path;
    }

    public void setFirst(boolean first){
        this.isFirst = first;
    }
    public  void setLast(boolean last){
        this.isLast = last;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public boolean isLast() {
        return isLast;
    }

    @Override
    public String toString() {
        if(this.isFirst)
            return "\u001B[32m"+ "1" +"\u001B[0m";
        if(this.isLast)
            return "\u001B[34m" +"2"+"\u001B[0m";
        if (this.wall)
            return "*";
        if (this.path)
            return "\u001B[35m"+"-"+"\u001B[0m";
        return " ";
    }


    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Node other = (Node) o;
        return this.getX() == other.getX() && this.getY() == other.getY();
    }


}
