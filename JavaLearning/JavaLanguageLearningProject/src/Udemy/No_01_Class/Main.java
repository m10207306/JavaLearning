package Udemy.No_01_Class;

public class Main {
    /*
     * package: 
     * 原則上同一個目錄下的 java file 都是同一個 package (folder 通常小寫, 偶爾 underline)
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
     * 呼叫本 class 的 constructor 可以用 this() 執行, 只能放在 constructor 第一行, 不能和 super() 共用
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
     * 所有物件的繼承源頭都是 java.lang.Object
     * 
     * super keyword:
     * 呼叫 parent class 的 method 跟 instance variable
     * 如果要呼叫 parent class 的 constructor, 也就是 super() 一定要放 constructor 第一行, 不能和 this() 共用
     * 
     * method override:
     * 複寫 parent class 的 method
     * 需要 return type, argument 完全一樣
     * 建議加上 @Override, 可以讓 compiler 幫你檢查, 也提升閱讀性
     * 
     * polymorphism:
     * parent class variable can refer to child class
     * 
     * dynamic binding:
     * 假設 B 是 A 的 child class
     * A obj = new B()
     * obj.hello()
     * 這個 hello 實際執行到哪一個 hello 是在 runtime 時決定, 並非 compile 時就決定 (也就是 static binding)
     * method overload 為 static binding
     * method override 為 dynamic binding
     * 
     * abstract class:
     * 不允許 instantiate (實體化)
     * 但是可以作為 data type 實作 polymorphism
     * 只要有 abstract method 就必須宣告為 abstact class
     * child class 都必須 override 每一個 abstract method, 然後實作內容
     * 可以有 constructor (因為可能還是要初始化 instance variable)
     * 
     * interface:
     * ex. 
     *    public interface interface1
     * 裡面的 method 都是 abstract method
     * 不允許 instantiate
     * 有個 class 要串接 interface 時, 語法使用 implements (可以多個)
     * interface 內的 variable (properties) 預設為 public static final
     * interface 也可以作為 data type 實作 polymorphism
     * 不允許 constructor
     * 
     * override:
     * override method 之後, access modifier 只能放大不能變小
     * 理由是 subclass 應該可以完全做到 superclass 的功能
     * 不能說繼承後 B 把某些 A 的 Method 改成 private, 這樣就變成有些 A 能做的事情 B 不能做
     * override method 假如原本回傳值是 return classA, 可以改成 return classB (A 的 subclass), 因為 B is a A
     * 
     */
    public static void main(String[] args) {
        // 同 Package (資料夾內) 可以直接存取
        Circle obj = new Circle();

        System.out.println(obj.radius);
        
        Circle obj2 = obj;

        System.out.println(obj.equals(obj2));
    }
}
