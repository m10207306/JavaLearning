package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.exercise.springboot_exersice_project.dto.CommentGetDto;
import com.springboot.exercise.springboot_exersice_project.dto.CommentPostDto;

public interface CommentService {
    public List<CommentGetDto> getAllComment();
    public CommentGetDto getComment(Integer id);

    public ResponseEntity<CommentGetDto> createComment(CommentPostDto body);
}
