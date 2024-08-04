package com.springboot.exercise.springboot_exersice_project.dto;

public class CommentGetDto {
    private Integer id;
    private Integer postId;
    private String title;
    private String body;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
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
        return "CommentGetDto [id=" + id + ", postId=" + postId + ", title=" + title + ", body=" + body + "]";
    }
}
