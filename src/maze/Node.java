package maze;

/**
 * The Node object.
 */
public class Node extends Coordinate {

    private Node parent;

    private int heuristicCost, finalCost, currentCost;

    private boolean isFirst, isLast;
    private boolean wall = false;
    private boolean path = false;



    private  String symbol;

    /**
     * Instantiates a new Node.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Node(int x, int y) {
        super(x, y);

    }

    /**
     * Calculate heuristic cost of a node.
     *
     * @param finalNode the final node (the exit) in order to calculate the heuristic cost
     */
    public void calculateHeuristic(Node finalNode) {
        int heuristic = Math.abs(finalNode.getX() - getX()) + Math.abs(finalNode.getY() - getY());
        this.setHeuristicCost(heuristic);
    }

    /**
     * Check better path boolean.
     *
     * @param currentNode the current node
     * @param cost        the cost
     * @return the boolean
     */
    public boolean checkBetterPath(Node currentNode, int cost) {
        int currentCost = currentNode.getCurrentCost() + cost;
        if (currentCost < this.getCurrentCost()) {
            setWeight(currentNode, cost);
            return true;
        }
        return false;
    }

    /**
     * Calculate final cost.
     */
    public void calculateFinalCost() {
        int finalCost = this.getCurrentCost() + this.getHeuristicCost();
        setFinalCost(finalCost);
    }

    /**
     * Sets weight.
     *
     * @param currentNode the current node
     * @param cost        the cost
     */
    public void setWeight(Node currentNode, int cost) {
        int currentCost = this.getCurrentCost() + cost;
        setParent(currentNode);
        setCurrentCost(currentCost);
        calculateFinalCost();

    }

    /**
     * Gets parent.
     *
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Sets parent.
     *
     * @param parent the parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Gets heuristic cost.
     *
     * @return the heuristic cost
     */
    public int getHeuristicCost() {
        return heuristicCost;
    }

    /**
     * Sets heuristic cost.
     *
     * @param heuristicCost the heuristic cost
     */
    public void setHeuristicCost(int heuristicCost) {
        this.heuristicCost = heuristicCost;
    }

    /**
     * Gets final cost.
     *
     * @return the final cost
     */
    public int getFinalCost() {
        return finalCost;
    }

    /**
     * Sets final cost.
     *
     * @param finalCost the final cost
     */
    public void setFinalCost(int finalCost) {
        this.finalCost = finalCost;
    }

    /**
     * Gets current cost.
     *
     * @return the current cost
     */
    public int getCurrentCost() {
        return currentCost;
    }

    /**
     * Sets current cost.
     *
     * @param currentCost the current cost
     */
    public void setCurrentCost(int currentCost) {
        this.currentCost = currentCost;
    }

    /**
     * Checks if the node is a wall
     *
     * @return the boolean
     */
    public boolean isWall() {
        return wall;
    }

    /**
     * Sets wall.
     *
     * @param wall the wall
     */
    public void setWall(boolean wall) {
        this.wall = wall;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(boolean path) {
        this.path = path;
    }

    /**
     * Sets first node (the entry).
     *
     * @param first the first
     */
    public void setFirst(boolean first) {
        this.isFirst = first;
    }

    /**
     * Sets last node (the exit).
     *
     * @param last the last
     */
    public void setLast(boolean last) {
        this.isLast = last;
    }

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets symbol.
     *
     * @param symbol the symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        if (this.isFirst)
            return "\u001B[32m" + "1" + "\u001B[0m";
        if (this.isLast)
            return "\u001B[34m" + "2" + "\u001B[0m";
        if (this.wall)
            return "*";
        if (this.path)
            return "\033[31m" + getSymbol() + "\033[0m";
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
