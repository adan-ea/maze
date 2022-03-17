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

  /*  private boolean explore(Maze maze, int row, int col, ArrayList<Coordinate> path) {
        while (openSet.size() != 0) {

        }
        if (!maze.isValidLocation(row, col) || maze.isWall(row, col)) {
            return false;
        }
        return true;
    }
*/

}
