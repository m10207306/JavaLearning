package Udemy.No_10_MethodChaining;

public class Main {
    public static void main(String[] args) {
        // 原本
        Person person = new Person();
        person.setAge(25);
        person.setGpa(3.5f);
        person.setMajor("CS");
        person.setName("Wilson");

        // Method chaining
        person.setAge2(25).setGpa2(3.5f).setMajor2("CS").setName2("Wilson");

    }   
}
