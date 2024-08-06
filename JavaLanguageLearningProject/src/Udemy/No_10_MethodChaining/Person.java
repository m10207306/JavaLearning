package Udemy.No_10_MethodChaining;

public class Person {
    private String name;
    private int age;
    private String major;
    private float gpa;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Person setName2(String name) {
        this.name = name;
        return this;
    }
    public Person setAge2(int age) {
        this.age = age;
        return this;
    }
    public Person setMajor2(String major) {
        this.major = major;
        return this;
    }
    public Person setGpa2(float gpa) {
        this.gpa = gpa;
        return this;
    }
}
