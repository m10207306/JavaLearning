package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.exercise.springboot_exersice_project.dto.PostGetDto;
import com.springboot.exercise.springboot_exersice_project.dto.PostPostDto;


public interface PostService {
    public List<PostGetDto> getAllPost();
    public PostGetDto getPost(Integer postId);

    public ResponseEntity<PostGetDto> createPost(PostPostDto body);
}
