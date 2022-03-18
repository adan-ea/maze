package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Labyrinth {

    private Node[][] grid;

    private Node start;
    private Node end;

    Labyrinth(File file) {
        initializeLabyrinth(readFile(file));
    }

    private String readFile(File file) {
        String fileStr = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = "";
            while ((readLine = bufferedReader.readLine()) != null) {
                fileStr += readLine + "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStr;
    }

    private void initializeLabyrinth(String fileText) {
        if (fileText == null || (fileText = fileText.trim()).length() == 0) {
            throw new IllegalArgumentException("empty lines data");
        }
        String[] lines = fileText.split("[\r]?\n");
        this.grid = new Node[lines.length + 1][lines[0].length() + 1];

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[0].length(); j++) {
                switch (lines[i].charAt(j)) {
                    case '1' -> {
                        this.start = new Node(i, j);
                        this.start.calculateHeuristic(getExit());
                        this.grid[i][j] = start;
                    }
                    case '2' -> {
                        this.end = new Node(i, j);
                        this.end.calculateHeuristic(getExit());
                        this.grid[i][j] = end;
                    }
                    case '*' -> {
                        this.grid[i][j] = new Node(i, j);
                        this.grid[i][j].setWall(true);
                    }
                    default -> {
                        Node node = new Node(i, j);
                        node.calculateHeuristic(getExit());
                        this.grid[i][j] = node;
                    }
                }
            }
        }
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[0].length(); j++) {
                System.out.print(this.grid[i][j]);
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return grid[0].length - 1;
    }

    public int getHeight() {
        return grid.length - 1;
    }

    public Node getEntry() {
        return start;
    }

    public boolean isEntry(int x, int y) {
        return x == start.getX() && y == start.getY();
    }

    public Node getExit() {
        return end;
    }

    public boolean isExit(int x, int y) {
        return x == end.getX() && y == end.getY();
    }

    public Node[][] getGrid() {
        return grid;
    }

    public boolean isValidLocation(int row, int col) {
        return row >= 0 && row < getHeight() && col >= 0 && col < getWidth();
    }
}
