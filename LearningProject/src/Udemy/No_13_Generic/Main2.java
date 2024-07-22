package Udemy.No_13_Generic;

import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        // Polymorphism 跟 Generic 的問題
        List<Animal> animals = List.of(new Dog(), new Cat());
        takeAnimals1(animals);   // OK, 使用到多型的概念

        System.out.println("=============");
        
        List<Dog> dogs = List.of(new Dog(), new Dog(), new Dog());
        // takeAnimals1(dogs);     //  Error, 有點違反多型的直覺, 但是如果可以成立, 進入 func 之後被加入 new Cat 不就混亂了？
        takeAnimals2(dogs);     // OK
        
        System.out.println("=============");

        List<Dog> vaccinateDogs1 = takeAnimals3(dogs);
        // List<Dog> vaccinateDogs2 = takeAnimals4(dogs); // 錯誤, 輸出不見得是 <Dog>
        List<? extends Animal> vaccinateDogs2 = takeAnimals4(dogs);    // 修正後, 外面也不確定他的 type 會是什麼

    }

    public static void takeAnimals1(List<Animal> animals) {
        /*
         * argument 只能接受 List<Animal>, 不可以是 List<Dog> 或是 List<Cat>
         * 不然如果接受 List<Dog> 進來之後卻被 add.(new Cat()) 會攪亂型別
         * 
         */
        for (Animal animal : animals) {
            animal.eat();           //  只能呼叫 Animal 範圍內的 method
        }
    }

    public static void takeAnimals2(List<? extends Animal> animals) {
        /*
         * 如果希望 argument 發揮多型的功能要使用通配符(wildcard)
         * 但是在 method 內無法對該變數做任何新增
         * 
         */
        for (Animal animal : animals) {
            animal.eat();           //  只能呼叫 Animal 範圍內的 method
        }
    }

    public static <T extends Animal> List<T> takeAnimals3(List<T> animals) {
        // 可以明確知道 return type 跟 argument type 相同
        return animals;
    }

    public static List<? extends Animal> takeAnimals4(List<? extends Animal> animals) {
        // 表示 return type 跟 argument type 都會是繼承 Animal 的 class, 但是不見得是相同的
        return animals;
    }
}

class Animal {
    void eat() {
        System.out.println("Animal eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog bark");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Cat meow");
    }
}
