package maze;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static java.lang.Math.sqrt;

public class AStarMazeSolver {

    private final Maze maze;
    private Node position;
    private Node[][] grid;
    private PriorityQueue<Node> openSet;
    private ArrayList<Node> closedSet;

    AStarMazeSolver(Maze maze) {
        this.maze = maze;
    }

    void initiateSolver() {
        maze.getEntry().setFinalCost(0);
        //grid[maze.getEntry().getX()][maze.getEntry().getY()].:
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
