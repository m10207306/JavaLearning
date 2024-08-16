package com.springboot.exercise.springboot_exersice_project.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class GetPostRs {
    @Schema(description = "此貼文的 id", example = "1")
    private Integer id;
    @Schema(description = "此貼文的 title", example = "Post title")
    private String title;
    @Schema(description = "此貼文的 body", example = "Post body")
    private String body;
    @Schema(description = "貼出此貼文的 user id", example = "1")
    private Integer userId;
    @Schema(description = "此貼文下面的 comment id", example = "1")
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
        return "GetPostRs [id=" + id + ", title=" + title + ", body=" + body + ", userId=" + userId + ", commentId="
                + commentId + "]";
    }
}
