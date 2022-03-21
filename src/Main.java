import maze.AStarMazeSolver;

import java.io.File;

import static constants.Constants.PATH;

/**
 * The Main Class.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String lab = System.getenv("LAB");
        File file = new File(PATH + "/" + lab + ".map.txt");
        AStarMazeSolver aStarMazeSolver = new AStarMazeSolver(file);
    }
}
