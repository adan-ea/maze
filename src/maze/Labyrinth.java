package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        this.grid = new Node[lines.length][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[0].length(); j++) {
                switch (lines[i].charAt(j)) {
                    case '1' -> {
                        this.start = new Node(i, j);
                        this.start.setFirst(true);
                        this.grid[i][j] = start;
                    }
                    case '2' -> {
                        this.end = new Node(i, j);
                        this.end.setLast(true);
                        this.grid[i][j] = end;
                    }
                    case '*' -> {
                        this.grid[i][j] = new Node(i, j);
                        this.grid[i][j].setWall(true);
                    }
                    default -> {
                        Node node = new Node(i, j);
                        this.grid[i][j] = node;
                    }
                }
            }
        }
    }

    public void displayGrid() {
        for (int i = 0; i < this.getGrid().length; i++) {
            for (int j = 0; j < this.getGrid()[0].length; j++) {
                System.out.print(this.grid[i][j]);
            }
            System.out.println();
        }
    }

    public Node getEntry() {
        return start;
    }

    public Node getExit() {
        return end;
    }

    public Node[][] getGrid() {
        return grid;
    }
}
