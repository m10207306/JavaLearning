package Udemy.No_03_FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File f = new File("./sleep.txt");
        int lineCount = 0, wordCount = 0, charCount = 0;

        try {
            Scanner scanner = new Scanner(f);

            // 讀取內容
            while (scanner.hasNextLine()) {
                String line  = scanner.nextLine();
                System.out.println(line);
            }
            
            // wc commnad
            scanner = new Scanner(f);   // 重新指向文件開頭
            while (scanner.hasNextLine()) {
                lineCount++;
                String line = scanner.nextLine();
                String[] lineArr = line.split(" ");
                for (String word : lineArr) {
                    wordCount++;
                }
                charCount += line.length();
            }
            System.out.println("lineCount: " + lineCount + ", wordCount: " + wordCount + ", charCount: " + charCount);
            
            scanner.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
