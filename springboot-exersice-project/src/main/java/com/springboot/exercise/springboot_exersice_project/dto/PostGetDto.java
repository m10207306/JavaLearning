package com.springboot.exercise.springboot_exersice_project.dto;

public class PostGetDto {
    private Integer id;
    private String title;
    private String body;
    private Integer userId;
    private Integer commentId;

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
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getCommentId() {
        return commentId;
    }
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
    @Override
    public String toString() {
        return "PostGetDto [id=" + id + ", title=" + title + ", body=" + body + ", userId=" + userId + ", commentId="
                + commentId + "]";
    }
}
