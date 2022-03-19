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
    private List<Node> path;
    private PriorityQueue<Node> openSet;
    private HashSet<Node> closedSet;

    public AStarMazeSolver(File file) {
        this.labyrinth = new Labyrinth(file);
        this.openSet = new PriorityQueue<Node>(new Comparator<Node>() {
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

    private void calcul(){
        for (int i = 0; i < labyrinth.getGrid().length; i++) {
            for (int j = 0; j < labyrinth.getGrid()[0].length ; j++) {
                labyrinth.getGrid()[i][j].calculateHeuristic(labyrinth.getExit());
            }
        }
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
            parent.setPath(true);
            currentNode = parent;
        }
        return path;
    }

        public void addNeighbors(Node  currentNode) {
            int row = currentNode.getX();
            int col = currentNode.getY();
            int lowerRow = currentNode.getX() +1;
            int middleRow = currentNode.getX();
            int upperRow = currentNode.getX()-1;
            if (row + 1 < this.labyrinth.getGrid()[0].length) {
                if (col - 1 >= 0) {
                    checkNode(currentNode, col - 1, lowerRow, Constants.DIAGONAL_COST);
                }
                if (col + 1 < labyrinth.getGrid()[0].length) {
                    checkNode(currentNode, col + 1, lowerRow, Constants.DIAGONAL_COST);
                }
                checkNode(currentNode, col, lowerRow, Constants.HV_COST);
            }
            if (col - 1 >= 0) {
                checkNode(currentNode, col - 1, middleRow, Constants.HV_COST);
            }
            if (col + 1 < labyrinth.getGrid()[0].length) {
                checkNode(currentNode, col + 1, middleRow, Constants.HV_COST);
            }
            if (upperRow >= 0) {
                if (col - 1 >= 0) {
                    checkNode(currentNode, col - 1, upperRow, Constants.DIAGONAL_COST);
                }
                if (col + 1 < labyrinth.getGrid()[0].length) {
                    checkNode(currentNode, col + 1, upperRow, Constants.DIAGONAL_COST);
                }
                checkNode(currentNode, col, upperRow, Constants.HV_COST);
            }
        }

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
