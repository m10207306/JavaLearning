package com.springboot.exercise.springboot_exersice_project.data;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Past(message = "Birth day should be in the past")
    private LocalDate birthDate;

    private List<Integer> postIds;

    public UserDetails() {
    }
    public UserDetails(Integer id, String name, @Past(message = "Birth day should be in the past") LocalDate birthDate,
            List<Integer> postIds) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.postIds = postIds;
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
    public List<Integer> getPostIds() {
        return postIds;
    }
    public void setPostIds(List<Integer> postIds) {
        this.postIds = postIds;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", postIds=" + postIds + "]";
    }
}
