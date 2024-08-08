package com.springboot.exercise.springboot_exersice_project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class CreatePostRq {
    // TODO: 補@Schema
    @Schema(description = "此貼文的 user id (創建貼文時required)", example = "1")
    private Integer userId;
    
    @NotNull
    @Schema(description = "此貼文的 title", example = "Post title", required = true)
    private String title;

    @Schema(description = "此貼文的 body (創建貼文時required)", example = "Post body")
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
