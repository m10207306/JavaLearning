package Udemy.No_00_Ex_Leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class LeetCode {
    static public void printEvery3() {
        for (int i = 1; i <= 88; i += 3) {
            System.out.print(i + " ");
        }
    }
    
    static public void ninetable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }

    static public int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; ++i) {
            max = arr[i] > max ? arr[i] : max;
        }

        return max;
    }

    static public int[] reverseArray(int[] arr) {
        int l_idx = 0, r_idx = arr.length - 1;
        while (l_idx < r_idx) {
            int temp = arr[l_idx];
            arr[l_idx] = arr[r_idx];
            arr[r_idx] = temp;

            l_idx++;
            r_idx--;
        }
        return arr;
    }

    static public int addUpTo(int n) {
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += i;
        }
        return sum;
    }

    static public void position(String str) {
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (Character.toUpperCase(c) == c) {
                System.out.println(c + " " + i);
                return;
            }
        }
        System.out.println(-1);
    }

    static public boolean confirmEnding(String str1, String str2) {
        // int str1_end_idx = str1.length();
        // int str2_size = str2.length();
        
        // String tar_str1 = str1.substring(str1_end_idx - str2_size, str1_end_idx);

        // if (tar_str1.equals(str2)) {
        //     return true;
        // }
        // else {
        //     return false;
        // }

        for (int i = 1; i <= str2.length(); ++i) {
            if (str1.charAt(str1.length() - i) != str2.charAt(str2.length() - i)) {
                return false;
            }
        }

        return true;
    }

    static public boolean findDuplicate(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length; ++i) {
            if (set.contains(arr[i])) {
                return true;
            }
            else {
                set.add(arr[i]);
            }
        }

        return false;
    }

    static public void pyramid(int n) {
        for (int i = 1; i <= n; ++i) {
            String str = String.valueOf('*').repeat(i);
            System.out.println(str);
        }
    }

    static public int findSmallCount(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < n) {
                count += 1;
            }
        }
        return count;
    }

    static public void calculateDroppingPathDistance() {
        Scanner s = new Scanner(System.in);

        System.out.println("輸入起始高度?");
        int h = s.nextInt();

        System.out.println("輸入第幾次落地?");
        int n = s.nextInt();

        double distance = h;
        for (int i = 2; i <= n; ++i) {
            distance +=  2 * (h / (Math.pow(2, i - 1)));
        }

        System.out.println(distance);
    }

    static public void getDayCountOfThisYear() {
        Scanner s = new Scanner(System.in);

        System.out.println("幾年?");
        int y = s.nextInt();

        System.out.println("幾月?");
        int m = s.nextInt();

        System.out.println("幾日?");
        int d = s.nextInt();

        boolean leapYear = (y % 4 == 0);
        int[] day_arr = {31, leapYear ? 29:28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
     
        int day_count = 0;
        for (int i = 0; i < m; ++i) {
            day_count += day_arr[i];
        }

        day_count += d;

        System.out.println(day_count);
    }

    static public boolean checkPalindrome(String str) {
        int l_idx = 0, r_idx = str.length() - 1;

        while (l_idx < r_idx) {
            if (str.charAt(l_idx) != str.charAt(r_idx)) {
                return false;
            }
            l_idx++;
            r_idx--;
        }
        return true;
    }

    static public void checkNarcissisticNumber(int number) {
        int hundreds = number / 100;
        int tens = (number % 100) / 10;
        int unit = number % 10;

        if (number == (Math.pow(hundreds, 3) + Math.pow(tens, 3) + Math.pow(unit, 3))) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }

    static public void getRepeatSum() {
        Scanner s = new Scanner(System.in);

        System.out.println("給我一個數字");
        int a = s.nextInt();

        System.out.println("處理幾次？");
        int n = s.nextInt();

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                sum += (a * Math.pow(10, j));
            }
        }

        System.out.println(sum);
    }

    static public void intersection (int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(1) + 1);
            }
            else {
                map.put(i, 1);
            }
        }

        for (int i : arr2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(1) + 1);
            }
            else {
                map.put(i, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer i : map.keySet()) {
            if (map.get(i) > 1) {
                result.add(i);
            }
        }

        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    static public void rightShift(int n, int[] arr) {
        int[] ret_arr = new int[arr.length];

        for (int i = 0; i < arr.length; ++i) {
            int new_idx = (i + n) % arr.length;
            ret_arr[new_idx] = arr[i];
        }

        for (int i : ret_arr) {
            System.out.print(i + " ");
        }
    }

    static public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    static public void getGcfAndLcm() {
        Scanner s = new Scanner(System.in);

        System.out.println("給我數字1");
        int i1 = s.nextInt();

        System.out.println("給我數字2");
        int i2 = s.nextInt();

        // 輾轉相除法
        int dividend = i1, divisor = i2;
        while (dividend % divisor != 0) {
            int remains = dividend % divisor;
            dividend = divisor;
            divisor = remains;
        }
        int gcf = divisor;
        System.out.println("最大公因數 " + gcf);
        
        // 公式： 最大公因數 * 最小公倍數 = i1 * i2
        int lcm = (i1 * i2) / gcf;
        System.out.println("最小公倍數 " + lcm);
    }

    static public void pyramid2(int n) {
        // for (int i = 1; i <= n; ++i) {
        //     int total_block = 2 * n - 1;
        //     int star_count = 1 + ((i-1) * 2);
        //     int space_count = (total_block - star_count) / 2;
        //     String starts = String.valueOf('*').repeat(star_count);
        //     String spaces = String.valueOf(' ').repeat(space_count);

        //     System.out.println(spaces + starts);
        // }

        int star_count = 1;
        int space_count = n - 1;
        while (space_count >= 0) {
            String starts = String.valueOf('*').repeat(star_count);
            String spaces = String.valueOf(' ').repeat(space_count);

            System.out.println(spaces + starts);

            space_count--;
            star_count += 2;
        }
    }

    static public void reversePyramid2(int n) {
        int star_count = 2 * n - 1;
        int space_count = 0;
        while (space_count <= (n - 1)) {
            String starts = String.valueOf('*').repeat(star_count);
            String spaces = String.valueOf(' ').repeat(space_count);

            System.out.println(spaces + starts);

            star_count -= 2;
            space_count++;
        }
    }
}