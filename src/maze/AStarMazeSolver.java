package maze;

import java.io.File;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarMazeSolver {

    private Labyrinth labyrinth;
    private Node position;
    private PriorityQueue<Node> openSet;
    private HashSet<Node> closedSet;

    public AStarMazeSolver(File file) {
        this.labyrinth = new Labyrinth(file);
        this.openSet = new PriorityQueue<>();
        this.closedSet = new HashSet<>();
        this.position = this.labyrinth.getEntry();

        initiateSolver();
    }

   private void initiateSolver() {
        labyrinth.getEntry().setFinalCost(0);
        openSet.add(labyrinth.getEntry());
        labyrinth.getEntry().setParent(null);
    }

    public void addNeighbors(Node[][] grid) {
        int row = this.position.getX();
        int col = this.position.getY();

        if (row + 1 < grid.length) {
            if (col - 1 >= 0) {
                checkNode(currentNode, col - 1, lowerRow, getDiagonalCost()); // Comment this line if diagonal movements are not allowed
            }
            if (col + 1 < getSearchArea()[0].length) {
                checkNode(currentNode, col + 1, lowerRow, getDiagonalCost()); // Comment this line if diagonal movements are not allowed
            }
            checkNode(currentNode, col, lowerRow, getHvCost());
        }
        if (col - 1 >= 0) {
            checkNode(currentNode, col - 1, middleRow, getHvCost());
        }
        if (col + 1 < getSearchArea()[0].length) {
            checkNode(currentNode, col + 1, middleRow, getHvCost());
        }
        if (upperRow >= 0) {
            if (col - 1 >= 0) {
                checkNode(currentNode, col - 1, upperRow, getDiagonalCost()); // Comment this if diagonal movements are not allowed
            }
            if (col + 1 < getSearchArea()[0].length) {
                checkNode(currentNode, col + 1, upperRow, getDiagonalCost()); // Comment this if diagonal movements are not allowed
            }
            checkNode(currentNode, col, upperRow, getHvCost());
        }
    }


}
