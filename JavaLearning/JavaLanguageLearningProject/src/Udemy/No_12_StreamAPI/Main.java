package Udemy.No_12_StreamAPI;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // // EX1
        // Stream.of("Ron", "Wilson", "Harry")
        //     .sorted()
        //     .forEach(System.out::println);
        //     // .forEach(x -> System.out.println(x));

        // // EX2
        // String[] names = {"Ron", "Wilson", "Harry", "Grace", "Mike"};
        // // method 1
        // Stream.of(names)
        // .sorted()
        // .forEach(x -> System.out.println());
        // // method 2
        // Arrays.stream(names)
        // .sorted()
        // .forEach(x -> System.out.println(x));
        
        // // EX2
        // String[] names2 = {"Ron", "Wilson", "Harry", "Grace", "Mike", "Ray"};
        // Arrays.stream(names2)
        //     .filter(name -> name.startsWith("R"))
        //     .forEach(x -> System.out.println(x));
        
        // // EX3
        // Arrays.stream(new int[] {2, 4, 6, 8, 10})
        //     .map(x -> x * x)
        //     .average()
        //     .ifPresent(System.out::println);
        
        // // EX4
        // ArrayList<String> people = new ArrayList<>();
        // people.add("Ron");
        // people.add("rat");
        // people.add("Wilson");
        // people.add("Harry");
        // people.add("Grace");
        // people.add("Mike");
        // people.add("Ray");

        // people.stream()
        //     .map(name -> name.toLowerCase())
        //     .filter(name -> name.startsWith("r"))
        //     .forEach(x -> System.out.println(x));

        // // EX5
        // Stream<String> bands = Files.lines(Paths.get("bands.txt"), StandardCharsets.UTF_8);
        
        // // implements 1
        // bands.sorted()
        //     .filter(x -> x.length() > 13)
        //     .forEach(x -> System.out.println(x));
        
        // // implements 2
        // List<String> myList = bands.filter(x -> x.contains("jit"))
        //                             .collect(Collectors.toList());
        // myList.forEach(x -> System.out.println(x));
        
        // bands.close();
        
        // // EX6
        // Stream<String> rows = Files.lines(Paths.get("data.txt"), StandardCharsets.UTF_8);
        // // rows.map(x -> x.split(","))
        // //     .filter(x -> x.length == 3)
        // //     .filter(x -> Integer.parseInt(x[1]) > 15)
        // //     .forEach(x -> System.out.println(x[0] + ", " + x[1] + ", " + x[2]));
        
        // Map<String, Integer> map;
        // map = rows.map(x -> x.split(","))
        //     .filter(x -> x.length == 3)
        //     .filter(x -> Integer.parseInt(x[1]) > 15)
        //     .collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));

        // map.forEach((k, v) -> {
        //     System.out.println(k + ", " + v);
        // });

        // rows.close();

        // // Ex7
        // IntSummaryStatistics s = IntStream.of(3, 4, 5, 6, 7, 8, 9, 10).summaryStatistics();
        // System.out.println(s.getMax());
        // System.out.println(s.getMin());
        // System.out.println(s.getAverage());
        // System.out.println(s.getCount());
        // System.out.println(s.getSum());

        // // Ex8
        // int result = Stream.of(3, 4, 5, 6, 7, 8).reduce(0, (Integer a, Integer b) -> a + b);
        // System.out.println(result);
        
        // result = Stream.of(3, 4, 5, 6, 7, 8).reduce(1, (Integer a, Integer b) -> a * b);
        // System.out.println(result);

        // Ex9
        Random random = new Random();
        int[] list = random.ints(50_000_000).toArray();
        System.out.println("Number of processers: " + Runtime.getRuntime().availableProcessors());

        long startTime = System.currentTimeMillis();
        int[] list1 = IntStream.of(list)
                                .filter(x -> x > 0)
                                .sorted()
                                .limit(5)
                                .toArray();
        System.out.println(Arrays.toString(list1));
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential execution time is " + (endTime - startTime) + " miliseconds");
        
        startTime = System.currentTimeMillis();
        int[] list2 = IntStream.of(list)
                                .parallel()
                                .filter(x -> x > 0)
                                .sorted()
                                .limit(5)
                                .toArray();
        endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(list2));
        System.out.println("Parallel execution time is " + (endTime - startTime) + " miliseconds");
    }
}
