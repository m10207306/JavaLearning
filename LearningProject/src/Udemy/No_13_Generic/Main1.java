package Udemy.No_13_Generic;

class Info<T> {
    private T value;

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class Info2<T, K> {
    private T key;
    private K value;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }
}

interface Content<T> {
    T text();
}

class GenericContent<T> implements Content<T> {

    private T text;

    public GenericContent(T text) {
        this.text = text;
    }

    @Override
    public T text() {
        return text;
    }

}

public class Main1 implements Content<Integer>{
    public static void main(String[] args) {
        // Class Generic (1 type)
        Info<String> myInfo = new Info<>();
        myInfo.setValue("Hello");
        System.out.println(myInfo.getValue());
        
        // Class Generic (2 type)
        Info2<String, Integer> myInfo2 = new Info2<>();
        myInfo2.setKey("Wilson");
        myInfo2.setValue(3000);
        System.out.println(myInfo2.getKey() + ", " + myInfo2.getValue());
        
        // Interface Generic (1 type)
        Main1 m = new Main1();
        System.out.println(m.text());
        
        // Interface Generic another way (1 type)
        GenericContent<String> gt =  new GenericContent<>("Hello");
        System.out.println(gt.text());

        // Method generic
        Main1.printClass("Hello");
        System.out.println(Main1.printHello("Wilson"));
    }

    @Override
    public Integer text() {
        return 15;
    }

    // 定義單獨 function 有 generic
    public static <T> void printClass(T obj) {
        System.out.println(obj.getClass().getName());
    }

    public static <T> T printHello(T obj) {
        return (T) (obj + ", Hello");
    }
}
