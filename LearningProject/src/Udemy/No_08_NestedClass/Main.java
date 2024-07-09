package Udemy.No_08_NestedClass;

import Udemy.No_08_NestedClass.Outer.StaticInner;

public class Main {
    public static void main(String[] args) {
        /*
         * Non-static class 稱為 inner class
         * static class 稱為 static nested class
         * 
         * Inner Class 優點：
         * 1. 邏輯分組
         * 2. 增加 Encapsulation:
         *      A B 兩個 Class, B 需要 Access A 的 member
         *      可以考慮把 B 定義為 A 的 inner class (假如其他地方都沒有使用到), 然後把 A 的 member 設定為 private
         *      B 本身對外也是隱藏的
         * 
         * Static Nested Class:
         * 不跟 Outer Class 的 instance 做綁定, 也因此無法存取 outer class 的 instance member
         * 但是可以存取 outer class 的 static member
         * 
         */

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.printI();

        Outer.StaticInner staticInner = new Outer.StaticInner();

    }
}
