package com.springboot.exercise.springboot_exersice_project.dto;

import java.time.LocalDate;
import java.util.List;

public class GetUserRs {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private List<Integer> posts;
    
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
    public List<Integer> getPosts() {
        return posts;
    }
    public void setPosts(List<Integer> posts) {
        this.posts = posts;
    }
    @Override
    public String toString() {
        return "GetUserRs [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", posts=" + posts + "]";
    }
    
}
