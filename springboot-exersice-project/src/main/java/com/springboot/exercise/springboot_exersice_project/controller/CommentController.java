package com.springboot.exercise.springboot_exersice_project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.exercise.springboot_exersice_project.dto.CommentGetDto;
import com.springboot.exercise.springboot_exersice_project.dto.CommentPostDto;
import com.springboot.exercise.springboot_exersice_project.entity.Comment;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;
import com.springboot.exercise.springboot_exersice_project.service.CommentServiceImp;


@RestController
public class CommentController {
    @Autowired
    CommentServiceImp commentServiceImp;

    @GetMapping("/comments")
    public List<CommentGetDto> getAllComment() {
        return commentServiceImp.getAllComment();
    }

    @GetMapping("/comments/{id}")
    public CommentGetDto getComment(@PathVariable Integer id) {
        return commentServiceImp.getComment(id);
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentGetDto> createComment(@RequestBody CommentPostDto body) {
        return commentServiceImp.createComment(body);
    }
}
