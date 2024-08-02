package com.springboot.exercise.springboot_exersice_project.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")   // 避免無限遞迴的問題
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String body;

    @ManyToOne
    private UserDetails userDetails;

    @OneToOne
    private Comment comment;

    public Post() {
    }
    public Post(Integer id, String title, String body, UserDetails userDetails, Comment comment) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userDetails = userDetails;
        this.comment = comment;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public UserDetails getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    public Comment getComment() {
        return comment;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", body=" + body + ", userDetails=" + userDetails + ", comment="
                + comment + "]";
    }
}
