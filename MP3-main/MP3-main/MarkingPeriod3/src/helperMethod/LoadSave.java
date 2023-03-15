package helperMethod;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class LoadSave {
    public static BufferedImage getSpriteAtlas() {
        BufferedImage img = null;
        File is = new File("./src/res/sprite.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    // lvl file
    public static void CreateFile() {
        File txtFile = new File("src/res/test.txt");
        try {
            txtFile.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void CreateLevel(String name, int[] idArr) {
        File newLevel = new File("src/res/" + name + ".txt");
        if (newLevel.exists()) {
            System.out.println("exists");
            return;
        } else {
            try {
                newLevel.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            WriteToFile(newLevel, idArr);
        }
    }

    private static void WriteToFile(File f, int[] idArr) {
        try {
            PrintWriter pw = new PrintWriter(f);
            for (int i : idArr) {
                pw.println(i);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void saveLevel(String name, int[][] idArr){
        File levelFile = new File("src/res/" + name + ".txt");

        if(levelFile.exists()){
            WriteToFile(levelFile, Utilz.twoDto1DIntArr(idArr));
        }
        else{
            System.out.println("File dont exist bruh");
            return;
        }
    

    }

    private static ArrayList<Integer> ReadFromFile(File file) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                list.add(Integer.parseInt(sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public static int[][] getLevelData(String name) {
        File lvlFile = new File("src/res/" + name + ".txt");
        if (lvlFile.exists()) {
            ArrayList<Integer> list = ReadFromFile(lvlFile);
            return Utilz.ArrayList2Dint(list, 20, 20);
        } else {
            System.out.print("DOESNT EXIST");
            return null;
        }
    }
}
