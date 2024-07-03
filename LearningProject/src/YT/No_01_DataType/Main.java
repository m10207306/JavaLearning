package YT.No_01_DataType;

public class Main {
    /*
     * byte: -128 ~ 127 => 1 byte
     * short: -32768 ~ 32767 => 2 bytes
     * int: 4 bytes
     * long: 8 bytes
     * float: 4 bytes, 精準至點後7位
     * double: 8 bytes, 精準至點後15位
     * boolean: 1bit, true / false
     * char: 2 bytes unsigned int (單引號)
     * string: 雙引號
     */
    public static void main(String[] args) {
        // 預設是 int
        System.out.println(1);
        System.out.println(120);
        
        int x = 1;
        System.out.println(x);
        x = 120;
        System.out.println(x);
        
        // System.out.println(20000000000);    // 超過 int 範圍 (210億), compile 失敗
        System.out.println(20000000000L);    // 改成 long
        
        // int y = 20000000000L; // 會出錯, data type 不符合
        long y = 20000000000L;
        System.out.println(y);

        // 預設是 double
        System.out.println(3.14159268);
        // 改成 float
        System.out.println(3.14159268f);
        
        double m = 3.14159268;
        System.out.println(m);
        
        // float n = 3.13159268;   // 會出錯
        float n = 3.13159268f;
        System.out.println(n);

        // boolean
        System.out.println(false);
        
        // char
        System.out.println('a');
        // System.out.println('aa'); // 會出問題
        
        // string
        System.out.println("aaaa");
    }
}
