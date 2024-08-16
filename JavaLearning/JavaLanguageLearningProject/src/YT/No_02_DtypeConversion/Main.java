package YT.No_02_DtypeConversion;
public class Main {
    public static void main(String[] args) {
        /*
         * 數字範圍：double > float > long > int > short > byte
         * 
         */
        
        // 小範圍資料轉大範圍資料 => OK
        byte x = 3;
        int y = x;
        System.out.println(y);
        
        long z = y;
        System.out.println(z);
        
        double zz = z;
        System.out.println(zz);
        
        // 大範圍轉小範圍
        int a = 1024;
        // byte b = a;  // 不允許
        byte b = (byte)a;
        System.out.println(b);  // 數字失真
        
        long c = 102400;
        int d = (int)c;
        System.out.println(d);  // 數字沒失真 （因為還在範圍內）
        
        // float e = 3.141592689; // 出錯：小數點數字預設為 double
        float e = 3.141592689f; // 數字失真
        System.out.println(e);  // 數字沒失真 （因為還在範圍內）
        
        // 字串轉數字
        String text = "34";
        int f = Integer.parseInt(text);
        System.out.println(f);
        
        text = "3.141592689";
        double g = Double.parseDouble(text);
        System.out.println(g);
        
        // 數字轉字串
        int h = 45;
        String i = String.valueOf(h);
        System.out.println(i);
        
        long j = 99999999;
        i = String.valueOf(j);
        System.out.println(i);
        
        i = String.valueOf(3.141592689);
        System.out.println(i);
    }
}