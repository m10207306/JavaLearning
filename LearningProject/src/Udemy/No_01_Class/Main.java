package Udemy.No_01_Class;

public class Main {
    /*
     * package: 
     * 原則上同一個目錄下的 java file 都是同一個 package
     * 宣告該 java file 的 package 語法是： package folder1.folder2.folder3 ....
     * 
     * constructor:
     * 函式必須跟 class 同名
     * 不能有回傳型別
     * 就算沒寫也會預設創建一個空的 constructor
     * 可以 overloading 許多 constructor
     * 
     * Scope:
     * Instance Variable => variable in a class (預設會被初始化) (C++ 的 member variable) (放 Heap)
     * Local Variable => method 內宣告的變數 (或是 for 迴圈的變數) (放 Stack)
     * 
     * this keyword:
     * 指的是當前物件, 通常在 constructor 中用來區分是 member variable 還是 local variable
     * 
     * static keywork:
     * 代表不需要創建實體也可以 呼叫的函式 或是 存取的變數
     * 在呼叫上都是使用 class.method 或是 class.var 而不是 obj.method
     * 
     * modifier: (method/variable)
     * public => 都可以讀取
     * protected => 同 package 跟 subclass 可以讀取
     * private => 同 class 可以讀取
     * default => (假如不寫預設就是 default) 同 package 可以讀取
     * 
     * encapsulation 封裝：
     * Instance variable 通常是 private，存取會另外設定 getter 或 setter
     * 
     * inheritance 繼承：
     * 只能繼承 1 個 parent class (不能多重繼承)
     * 語法是 extends
     * 
     * super keyword:
     * 
     * 
     */
    public static void main(String[] args) {
        // 同 Package (資料夾內) 可以直接存取
        Circle obj = new Circle();

        System.out.println(obj.radius);
    }
}
