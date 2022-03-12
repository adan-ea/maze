package maze;

import coordinate.Coordinate;

import java.io.*;

public class Maze {
    private int[][] maze;
    private boolean[][] visited;
    private Coordinate start;
    private Coordinate end;

    public Maze(File file) {
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        this.maze = new int[lines.length][lines[0].length()];
        this.visited = new boolean[lines.length][lines[0].length()];

        for (int row = 0; row < getHeight(); row++) {
            for (int colomn = 0; colomn < getWidth(); colomn++) {
                switch (lines[row].charAt(colomn)) {
                    case '*':
                        maze[row][colomn] = MazeElement.WALL.getValue();
                        break;
                    case '1':
                        maze[row][colomn] = MazeElement.START.getValue();
                        break;
                    case '2':
                        maze[row][colomn] = MazeElement.EXIT.getValue();
                        break;
                    default:
                        maze[row][colomn] = MazeElement.ROAD.getValue();
                }
            }
        }
        for (int[] row : maze){
            for (int colomn : row){
                System.out.print(colomn);
            }
            System.out.println();
        }
    }

    public int getHeight() {
        return this.maze.length;
    }

    public int getWidth() {
        return this.maze[0].length;
    }
}
