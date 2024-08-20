package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "course")    // 指定此 class 對應到的 DB name
public class Course {
    
    @Id                     // 指定 Primary Key
    private long id;
    @Column(name = "name")  // 指定此 properties 對應到 DB 的 column name
    private String name;
    @Column(name = "author")
    private String author;

    public Course() {
    }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }

}
