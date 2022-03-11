package graph;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Maze {

    private String path;
    private String[][] map;

    public Maze(String path) {
        this.path = path;
        generateMaze();
    }

    private void generateMaze() {
        Path path = Paths.get(this.path);
        BufferedReader reader;
        List<char[]> maps = new ArrayList<char[]>();
        try {
            reader = new BufferedReader(new FileReader(this.path));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                maps.add(line.toCharArray());
                line = reader.readLine();
            }
            for (int i  = 0 ; i <maps.size();i++){
                for (int j  = 0 ; j < maps.get(i).length;j++){
                    System.out.print(maps.get(i)[j]);

                }
                System.out.println(" ");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

