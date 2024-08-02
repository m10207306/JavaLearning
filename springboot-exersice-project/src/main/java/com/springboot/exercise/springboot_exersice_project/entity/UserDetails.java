package com.springboot.exercise.springboot_exersice_project.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Past(message = "Birth day should be in the past")
    private LocalDate birthDate;

    @OneToMany  // 這會多一個 table 去 mapping user 跟 post 兩個 table
    private List<Post> posts;

    public UserDetails() {
    }
    public UserDetails(Integer id, String name, @Past(message = "Birth day should be in the past") LocalDate birthDate,
            List<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.posts = posts;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    @Override
    public String toString() {
        return "UserDetails [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", posts=" + posts + "]";
    }
}
