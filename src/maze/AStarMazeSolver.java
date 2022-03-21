package maze;

import constants.Constants;

import java.io.File;
import java.util.*;

public class AStarMazeSolver {

    /**
     * Gets or sets labyrinth;
     */
    private final Labyrinth labyrinth;

    /**
     * Gets or sets path;
     */
    private final List<Node> path;

    /**
     * Gets or sets openSet;
     */
    private final PriorityQueue<Node> openSet;

    /**
     * Gets or sets closedSet;
     */
    private final HashSet<Node> closedSet;

    public AStarMazeSolver(File file) {
        this.labyrinth = new Labyrinth(file);
        this.openSet = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node0, Node node1) {
                return Integer.compare(node0.getFinalCost(), node1.getFinalCost());
            }
        });
        this.closedSet = new HashSet<>();

        initiateSolver();
        this.calcul();

        this.path = this.findPath();
        this.labyrinth.displayGrid();
    }

    /**
     * Initialise everything needed to solve the maze.
     */
    private void initiateSolver() {
        labyrinth.getEntry().setFinalCost(0);
        openSet.add(labyrinth.getEntry());
        labyrinth.getEntry().setParent(null);
    }

    /**
     * Calculate the heuristical cost of a node
     */
    private void calcul() {
        for (int i = 0; i < labyrinth.getGrid().length; i++) {
            for (int j = 0; j < labyrinth.getGrid()[0].length; j++) {
                labyrinth.getGrid()[i][j].calculateHeuristic(labyrinth.getExit());
            }
        }
    }

    /**
     * Adds all the neighbors of the currentNode in a list
     *
     * @param currentNode the position of the actual node
     */
    public void addNeighbors(Node currentNode) {
        int row = currentNode.getX();
        int col = currentNode.getY();
        int lowerRow = currentNode.getX() + 1;
        int middleRow = currentNode.getX();
        int upperRow = currentNode.getX() - 1;
        if (row + 1 < (this.labyrinth.getGrid().length)) {
            addRows(currentNode, col, lowerRow);
        }
        if (col - 1 >= 0) {
            checkNode(currentNode, col - 1, middleRow, Constants.HV_COST, "-");
        }
        if (col + 1 < labyrinth.getGrid()[0].length) {
            checkNode(currentNode, col + 1, middleRow, Constants.HV_COST, "-");
        }
        if (upperRow >= 0) {
            addRows(currentNode, col, upperRow);
        }
    }

    /**
     * Creates the path from the entry to the exit
     *
     * @param  currentNode the position of the actual node
     * @return             a List with the nodes constructing the path
     */
    private List<Node> getPath(Node currentNode) {
        List<Node> path = new ArrayList<Node>();
        path.add(currentNode);
        Node parent;
        while ((parent = currentNode.getParent()) != null) {
            path.add(0, parent);
            parent.setPath(true);
            currentNode = parent;
        }
        return path;
    }

    /**
     * Looks in the grid in order to find the best possible path to take.
     *
     * @return a List of all the nodes constructing the path
     */
    public List<Node> findPath() {
        openSet.add(this.labyrinth.getEntry());
        while (!isEmpty(openSet)) {
            Node currentNode = openSet.poll();
            closedSet.add(currentNode);
            if (isFinalNode(currentNode)) {
                return getPath(currentNode);
            } else {
                addNeighbors(currentNode);
            }
        }
        return new ArrayList<>();
    }

    /**
     * Checks the next node to be visited to assert that it is not a wall.
     * Then, it changes the weight of the node and compare if there is another better path to take.
     *
     * @param currentNode the position of the actual node
     * @param col         the column on the grid
     * @param row         the row on the grid
     * @param cost        the total cost to move to this node
     * @param symbole     String to print the path depending on the movement
     */
    private void checkNode(Node currentNode, int col, int row, int cost, String symbole) {
        Node adjacentNode = labyrinth.getGrid()[row][col];
        if (!adjacentNode.isWall() && !closedSet.contains(adjacentNode)) {
            if (!openSet.contains(adjacentNode)) {
                adjacentNode.setWeight(currentNode, cost);
                currentNode.setSymbol(symbole);
                openSet.add(adjacentNode);
            } else {
                boolean changed = adjacentNode.checkBetterPath(currentNode, cost);
                if (changed) {
                    // Remove and Add the changed node, so that the PriorityQueue can sort again its
                    // contents with the modified "finalCost" value of the modified node
                    openSet.remove(adjacentNode);
                    openSet.add(adjacentNode);
                }
            }
        }
    }

    /**
     * Adds all the nodes within the range of the actual node
     *
     * @param currentNode the position of the actual node
     * @param col         the column on the grid
     * @param row         the row on the grid
     * @see               Node
     */
    private void addRows(Node currentNode, int col, int row) {
        if (col - 1 >= 0) {
            checkNode(currentNode, col - 1, row, Constants.DIAGONAL_COST, "|");
        }
        if (col + 1 < labyrinth.getGrid()[0].length) {
            checkNode(currentNode, col + 1, row, Constants.DIAGONAL_COST, "-");
        }
        checkNode(currentNode, col, row, Constants.HV_COST, "|");
    }

    /**
     * Checks if the current nodes has the same coordinates as the exit
     *
     * @param  currentNode the actual position of the Node
     * @return             a boolean
     * @see                Node
     */
    private boolean isFinalNode(Node currentNode) {
        return currentNode.equals(labyrinth.getExit());
    }

    /**
     * Checks if the list of neighbors is empty or not
     *
     * @param openSet the list of neighbors of the current Node
     * @return        boolean
     */
    private boolean isEmpty(PriorityQueue<Node> openSet) {
        return openSet.size() == 0;
    }
}
