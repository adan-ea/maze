import maze.Maze;

import java.io.File;

import static constants.Constants.PATH;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world");
        File file = new File(PATH + "/rect_05.map.txt");
        Maze maze = new Maze(file);

    }
}

