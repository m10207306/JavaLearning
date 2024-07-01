import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // int x = s.nextInt();
        // System.out.println(x);
        
        
        // Scanner s = new Scanner(System.in);
        // System.out.println("要領多少錢？");
        // int x = s.nextInt();
        // if (x > 100000) {
        //     System.out.println("太多！");
        // }
        // else if (x > 100) {
        //     System.out.println("OK");
        // }
        // else {
        //     System.out.println("太少！");
        // }

        int n1 = 3, n2 = 4;
        System.out.println("請輸入想要做的運算 (+-*/)");
        Scanner s = new Scanner(System.in);
        String op = s.next();
        switch (op) {
            case "+":
                System.out.println(n1 + n2);
                break;
            case "-":
                System.out.println(n1 - n2);
                break;
            case "*":
                System.out.println(n1 * n2);
                break;
            case "/":
                System.out.println(n1 / n2);
                break;
            default:
                System.out.println("不支援的運算");
                break;
        }
    }
}
