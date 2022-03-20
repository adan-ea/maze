import maze.AStarMazeSolver;

import java.io.File;

import static constants.Constants.PATH;

public class Main {
    public static void main(String[] args) {
        String lab = args[0];
        File file = new File(PATH + "/" + lab + ".map.txt");
        AStarMazeSolver aStarMazeSolver = new AStarMazeSolver(file);
    }
}
