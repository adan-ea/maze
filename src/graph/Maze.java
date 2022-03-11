package graph;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Maze {

    private String path;
    private String[][] map;

    public Maze(String path) {
        this.path = path;
        generateMaze();
    }

    private void generateMaze() {
        Path path = Paths.get(this.path);

        try {
            String content = Files.readString(path);
            System.out.println(content);
            char[] chars = content.toCharArray();
            for (int i = 0; i<chars.length;i++ ){
                System.out.println(chars[i]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
