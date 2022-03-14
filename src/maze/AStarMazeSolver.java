package maze;

import static java.lang.Math.sqrt;

public class AStarMazeSolver {
    private Node start;
    private Node end;
    private Node position;
    private Maze maze;
    private Node[][] grid;

    AStarMazeSolver(Node start, Node end, Maze maze) {
        this.start = start;
        this.position = start;
        this.end = end;
        this.maze = maze;
    }

    void initiateSolver(){
        //TODO
        //Empty the closed list to avoid memory issue

        //Initialise the starting location


    }
    void determineHeuristicCost(){
        int dx = end.getX() - position.getX();
        int dy = end.getY() - position.getY();
        position.setHeuristicCost((int) sqrt((dx*dx)+(dy*dy)));
    }


}
