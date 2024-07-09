package Udemy.No_02_Exception;

public class Person {
    private String name;
    private int age;
    private Person spouse;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // java.lang.NullPointerException version
    // public void talk() {
    //     System.out.println("Hello, my name is " + name + " and my spouse is " + spouse.getName());
    // }


    // fix java.lang.NullPointerException version
    public void talk() {
        if (spouse != null) {
            System.out.println("Hello, my name is " + name + " and my spouse is " + spouse.getName());
        }
        else {
            System.out.println("Hello, my name is " + name + " and i am not yet married");
        }
    }

    public String getName() {
        return this.name;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }
}
