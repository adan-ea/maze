import maze.AStarMazeSolver;

import java.io.File;

import static constants.Constants.PATH;

public class Main {
    public static void main(String[] args) {
        String lab = System.getenv("LAB");
        File file = new File(PATH + "/" + lab + ".map.txt");
        // File file  = new File(PATH+ "/" + "rect_01.map.txt");
        AStarMazeSolver aStarMazeSolver = new AStarMazeSolver(file);
    }
}
