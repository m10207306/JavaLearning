package com.springboot.exercise.springboot_exersice_project.dto;

import jakarta.validation.constraints.NotNull;

public class CreateCommentRq {
    
    private Integer postId;

    @NotNull
    private String body;
    
    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    @Override
    public String toString() {
        return "CreateCommentRq [postId=" + postId + ", body=" + body + "]";
    }
}
