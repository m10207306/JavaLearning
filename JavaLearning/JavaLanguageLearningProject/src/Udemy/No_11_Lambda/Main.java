package Udemy.No_11_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
    
}

public class Main {
    public static void main(String[] args) {
        // EX1
        int[] arr = Arrays.stream(new int[] {1, 2, 3, 4, 5}).map(x -> x * 5).toArray();
        for (int i : arr) {
            System.out.println(i);
        }
        
        // EX2
        arr = Arrays.stream(new int[] {1, 2, 3, 4, 5}).map(x -> {
            if (x == 3) {
                return x * 10;
            }
            else {
                return x * 5;
            }
        }).toArray();
        for (int i : arr) {
            System.out.println(i);
        }

        // EX3
        ArrayList<Integer> arrlist = new ArrayList<>();
        arrlist.add(1);
        arrlist.add(2);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(5);

        arrlist.forEach(element -> {
            System.out.println(element);
        });

        // EX4
        Map<String, Integer> salaryMap = new HashMap<>();
        salaryMap.put("Wilson", 3000);
        salaryMap.put("Grace", 5000);
        salaryMap.put("Mike", 3500);

        salaryMap.forEach((k, v) -> {
            System.out.println("key is " + k + ", value is " + v);
        });

        // EX5
        MyRunnable r1 = new MyRunnable();
        Thread t1 = new Thread(r1);
        t1.start();;
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
            }
        });
        t2.start();
        
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        });
        t3.start();
    }
}
