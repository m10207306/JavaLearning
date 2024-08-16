package Udemy.No_02_Exception;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    int age;
    String ageString;

    public Main() {
        ageString = JOptionPane.showInputDialog("what is your age?");

        // ==================== try catch ======================
        /*
         * 數學除 0 導致 ArithmeticException
         * 存取 Null pointer 導致 NullPointerException
         * index 超出 array 長度時導致 IndexOutOfBoundsException
         * Scanner 讀取文件卻找不到文件時導致 FileNotFoundException
         */
        try {
            age = Integer.parseInt(ageString);
            if (age < 18) {
                System.out.println("you can't drive");
            }
            else {
                System.out.println("you can drive");
            }
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Invalid input");
        }


    }

    public static void main(String[] args) {
        // // ==================== java.lang.NullPointerException ======================
        
        // // Person wilsom = new Person("Wilsom", 25);
        // // wilsom.talk();  // java.lang.NullPointerException
        
        // Person wilsom = new Person("Wilsom", 25);
        // Person grace = new Person("Grace", 25);
        // wilsom.setSpouse(grace);
        // grace.setSpouse(wilsom);
        
        // wilsom.talk();

        // // ==================== java.util.ConcurrentModificationException ======================
        // ArrayList<Integer> arr =  new ArrayList<>();

        // for (int i = 0; i < 20; i++) {
        //     arr.add(i);
        // }

        // for (int k : arr) {
        //     if (k == 10) {
        //         arr.remove(k);  // java.util.ConcurrentModificationException
        //     }
        // }

        
        // ==================== try catch ======================
        // Main obj = new Main();
        
        // ==================== throw ======================
        // Circle c1 = new Circle(10);
        // try {
        //     c1.setRadius(-5);
        // }
        // catch (IllegalArgumentException e) {
        //     e.printStackTrace();
        // }
        
        // ==================== throw ======================
        Circle c1 = new Circle(0);
        try {
            c1.testThrows("a");
        }
        catch (AssertionError e) {
            System.out.println("catch AssertionError!");
        }
        catch (RuntimeException e) {
            System.out.println("catch IllegalArgumentException!");
            e.printStackTrace();
        }
        
    }
}
