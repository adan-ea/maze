import maze.Maze;

import java.io.File;

public class Main {
    public static void main(String[] args)  {

        System.out.println("Hello world");
        File file = new File("./ressources/oval_01.map.txt");
        Maze maze = new Maze(file);
    }
}

