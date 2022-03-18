import maze.AStarMazeSolver;

import java.io.File;

import static constants.Constants.PATH;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world");
        File file = new File(PATH + "/rect_05.map.txt");
        AStarMazeSolver aStarMazeSolver = new AStarMazeSolver(file);
    }
}
