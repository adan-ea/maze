package maze;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Maze {

    private Node[][] grid;

    private PriorityQueue<Node> openSet;
    private ArrayList<Node> closedSet;

    private Node start;
    private Node end;


    public Maze(File file){
        this.openSet = new PriorityQueue<Node>((Node node1, Node node2) ->{
            return node1.getFinalCost() < node2.getFinalCost() ? 1 : node1.getFinalCost() == node2.getFinalCost() ? 0 : 1;
        });
        initalizeMaze(readFile(file));
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

    private void initalizeMaze(String fileText) {
        if (fileText == null || (fileText = fileText.trim()).length() == 0) {
            throw new IllegalArgumentException("empty lines data");
        }
        String[] lines = fileText.split("[\r]?\n");
        this.grid = new Node[lines.length+1][lines[0].length()+1];

         for (int i = 0; i < lines.length; i++){
            for (int j = 0; j < lines[0].length(); j++) {
                switch (lines[i].charAt(j)) {
                    case '1' -> {
                        this.start = new Node(i, j);
                        this.grid[i][j] = start;
                    }
                    case '2' -> {
                        this.end = new Node(i, j);
                        this.grid[i][j] = end;
                    }
                    case '*' -> {
                        this.grid[i][j] = new Node(i, j);
                        this.grid[i][j].setWall(true);
                    }
                    default -> this.grid[i][j] = new Node(i, j);
                }
            }
        }
        for (int i = 0; i < lines.length; i++){
            for (int j = 0; j < lines[0].length(); j++) {
                this.grid[i][j].addNeighbors(this.grid);
                System.out.print(this.grid[i][j]);
            }
            System.out.println();
        }

    }

    public PriorityQueue<Node> getOpenSet() {
        return openSet;
    }

    public void setOpenSet(PriorityQueue<Node> openSet) {
        this.openSet = openSet;
    }

    public ArrayList<Node> getClosedSet() {
        return closedSet;
    }

    public void setClosedSet(ArrayList<Node> closedSet) {
        this.closedSet = closedSet;
    }

}

