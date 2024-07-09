package Udemy.No_08_NestedClass;

public class Outer {
    private int i = 0;
    private void printHello() {
        System.out.println("hello");
    }

    class Inner {
        void printI() {
            System.out.println(i);
            printHello();
        }
    }

    public static class StaticInner {
        // public void hello() {
        //     System.out.println(i);  // 無法存取, compile 會失敗
        // }
    }
}
