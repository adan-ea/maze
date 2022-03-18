package maze;

import constants.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.*;

public class AStarMazeSolver {

    private Labyrinth labyrinth;

    private Node position;
    private Node finalNode;

    private PriorityQueue<Node> openSet;
    private HashSet<Node> closedSet;

    public AStarMazeSolver(File file) {
        this.labyrinth = new Labyrinth(file);
        this.openSet = new PriorityQueue<>();
        this.closedSet = new HashSet<>();
        this.position = this.labyrinth.getEntry();
        this.finalNode = labyrinth.getExit();
        initiateSolver();
    }

    private void initiateSolver() {
        labyrinth.getEntry().setFinalCost(0);
        openSet.add(labyrinth.getEntry());
        labyrinth.getEntry().setParent(null);
    }

    private List<Node> getPath(Node currentNode) {
        List<Node> path = new ArrayList<Node>();
        path.add(currentNode);
        Node parent;
        while ((parent = currentNode.getParent()) != null) {
            path.add(0, parent);
            currentNode = parent;
        }
        return path;
    }

        public void addNeighbors(Node[][] grid) {
            int row = this.position.getX();
            int col = this.position.getY();

            if (row + 1 < grid.length) {
                if (col - 1 >= 0) {
                    checkNode(position, col - 1, lowerRow, Constants.DIAGONAL_COST);
                }
                if (col + 1 < labyrinth.getGrid()[0].length) {
                    checkNode(position, col + 1, lowerRow, Constants.DIAGONAL_COST);
                }
                checkNode(position, col, lowerRow, Constants.HV_COST);
            }
            if (col - 1 >= 0) {
                checkNode(position, col - 1, middleRow, Constants.HV_COST);
            }
            if (col + 1 < labyrinth.getGrid()[0].length) {
                checkNode(position, col + 1, middleRow, Constants.HV_COST);
            }
            if (upperRow >= 0) {
                if (col - 1 >= 0) {
                    checkNode(position, col - 1, upperRow, Constants.DIAGONAL_COST);
                }
                if (col + 1 < labyrinth.getGrid()[0].length) {
                    checkNode(position, col + 1, upperRow, Constants.DIAGONAL_COST);
                }
                checkNode(position, col, upperRow, Constants.HV_COST);
            }
        }

    public List<Node> findPath() {
        openSet.add(position);
        while (!isEmpty(openSet)) {
            Node currentNode = openSet.poll();
            closedSet.add(currentNode);
            if (isFinalNode(currentNode)) {
                return getPath(currentNode);
            } else {
                addAdjacentNodes(currentNode);
            }
        }
        return new ArrayList<Node>();
    }

    private void checkNode(Node currentNode, int col, int row, int cost) {
        Node adjacentNode = labyrinth.getGrid()[row][col];
        if (!adjacentNode.isWall() && !closedSet.contains(adjacentNode)) {
            if (!openSet.contains(adjacentNode)) {
                adjacentNode.setWeight(currentNode, cost);
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
    private boolean isFinalNode(Node currentNode) {
        return currentNode.equals(labyrinth.getExit());
    }
    private boolean isEmpty(PriorityQueue<Node> openSet) {
        return openSet.size() == 0;
    }
}
