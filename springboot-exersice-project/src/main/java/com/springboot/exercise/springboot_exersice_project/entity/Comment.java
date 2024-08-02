package com.springboot.exercise.springboot_exersice_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Post post;

    private String title;

    private String body;
    
    public Comment() {
    }
    public Comment(Integer id, Post post, String title, String body) {
        this.id = id;
        this.post = post;
        this.title = title;
        this.body = body;
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
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    @Override
    public String toString() {
        return "Comment [id=" + id + ", post=" + post + ", title=" + title + ", body=" + body + "]";
    }
}
