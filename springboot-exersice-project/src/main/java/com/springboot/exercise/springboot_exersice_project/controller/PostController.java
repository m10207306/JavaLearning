package com.springboot.exercise.springboot_exersice_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exercise.springboot_exersice_project.dto.PostGetDto;
import com.springboot.exercise.springboot_exersice_project.dto.PostPostDto;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.service.PostServiceImp;

@RestController
public class PostController {
    @Autowired
    PostServiceImp postServiceImp;

    @GetMapping("/posts")
    public List<PostGetDto> getAllPost() {
        return postServiceImp.getAllPost();
    }

    @GetMapping("/posts/{postId}")
    public PostGetDto getPost(@PathVariable Integer postId) {
        return postServiceImp.getPost(postId);
    }

    @PostMapping("/posts")
    public ResponseEntity<PostGetDto> createPost(@RequestBody PostPostDto body) {
        return postServiceImp.createPost(body);
    }
}
