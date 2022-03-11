import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Hello world");
        // path = Paths.get("./Users/wylhemdorville/Desktop/apps/maze/src/ressources/oval_01.map.txt");

        try {
            File f = new File("./ressources/oval_01.map.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.next();
                System.out.println(line);
            }
            sc.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}

