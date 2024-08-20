package com.springboot.exercise.springboot_exersice_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exercise.springboot_exersice_project.dto.GetPostRs;
import com.springboot.exercise.springboot_exersice_project.dto.CreatePostRq;
import com.springboot.exercise.springboot_exersice_project.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/posts")
    @Operation(
        summary = "取得所有貼文",
        description = "取得所有貼文"
    )
    public List<GetPostRs> getAllPost() {
        return postService.getAllPost();
    }
    
    @GetMapping("/posts/{postId}")
    @Operation(
        summary = "取得特定貼文",
        description = "根據 [postId] 取得特定貼文"
    )
    public GetPostRs getPost(@PathVariable @Parameter(description = "貼文 ID", required = true) Integer postId) {
        return postService.getPost(postId);
    }
    
    @PostMapping("/posts")
    @Operation(
        summary = "創建貼文",
        description = "提供 [userId] [title] [body] 創建新貼文"
    )
    public ResponseEntity<GetPostRs> createPost(@Valid @RequestBody CreatePostRq body) {
        return ResponseEntity.created(null).body(postService.createPost(body));
    }
    
    @DeleteMapping("/posts/{postId}")
    @Operation(
        summary = "刪除貼文",
        description = "根據 [postId] 刪除特定貼文"
    )
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/posts/{postId}/title")
    @Operation(
        summary = "更新貼文標題",
        description = "根據 [postId] 並提供 [title] 更新貼文標題"
    )
    public ResponseEntity<GetPostRs> updatePostTitle(@PathVariable Integer postId, @Valid @RequestBody CreatePostRq body) {
        return ResponseEntity.ok().body(postService.updatePostTitle(postId, body));
    }
}
