package Udemy.No_14_TypeErasure;

public class Main {
    public static void main(String[] args) {
        Info<String> info = new Info<>("hello");
        String message = info.getInfo();
        System.out.println(message);

        /*
         * 實際上上面這段程式, 配合 Info 的 compiler 版本, 要改成:
         * Info info = new Info("hello");
         * String message = (String)info.getInfo();
         * 也就是原本是吐出 Object 再根據你的程式 casting 成 String
         */


        /*
         * Generic 的限制
         * 1. T 不能放 primitive type, 只能放 Object
         * 2. 同一個 class, 不同 T, getClass().getName() 出來的內容都只有 Class, 不包含 T 的型別
         * 3. 假設有個 Generic Type 叫做 E, 不能執行：
         *      E e = new E();
         *      因為 type erasure 後會變成：
         *      Object e = (Integer) new Object();
         *      等號右邊是不合法的
         * 4. 不能創建 Array of Generic Type
         *      E[] elements = new E[100];
         *      理由同3
         * 5. Generic Type 不能用在 static context
         *      例如 ArrayList<E> 這個 class 中存在一個 static E x;
         *      那對 ArrayList<Integer> 來說 x 是 Integer
         *      那對 ArrayList<String> 來說 x 是 String
         * 
         *      但是實際上他們兩個應該都是共他同一個 x, 因為他是 static, 因此就會衝突
         */
    }
}
