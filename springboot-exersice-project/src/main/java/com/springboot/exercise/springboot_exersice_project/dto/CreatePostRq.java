package com.springboot.exercise.springboot_exersice_project.dto;

import jakarta.validation.constraints.NotNull;

public class CreatePostRq {
    private Integer userId;

    @NotNull
    private String title;

    private String body;
    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Override
    public String toString() {
        return "CreatePostRq [userId=" + userId + ", title=" + title + ", body=" + body + "]";
    }
}
