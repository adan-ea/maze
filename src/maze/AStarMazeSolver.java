package maze;

import java.io.File;
import java.util.HashSet;
import java.util.PriorityQueue;
import static constants.Constants.DEFAULT_PATH;
import static java.lang.Math.sqrt;

public class AStarMazeSolver {

    private Maze maze;
    private Node position;
    private PriorityQueue<Node> openSet;
    private HashSet<Node> closedSet;

    public AStarMazeSolver(File file) {
        maze = new Maze(file);
        this.openSet = new PriorityQueue<>();
        this.closedSet = new HashSet<>();
    }

   private void initiateSolver() {
        maze.getEntry().setFinalCost(0);
        //grid[maze.getEntry().getX()][maze.getEntry().getY()].:
        this.position =
        openSet.clear();
        openSet.add(maze.getEntry());
        closedSet.clear();
        maze.getEntry().setParent(null);
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
