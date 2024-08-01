package com.springboot.exercise.springboot_exersice_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.exercise.springboot_exersice_project.data.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.data.Post;
import com.springboot.exercise.springboot_exersice_project.data.PostRepository;
import com.springboot.exercise.springboot_exersice_project.data.UserDetailsRepository;

@RestController
public class PostController {
    private UserDetailsRepository userDetailsRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public PostController(UserDetailsRepository userDetailsRepository, PostRepository postRepository,
            CommentRepository commentRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("posts/{id}")
    public Post getPost(@PathVariable Integer id) {
        return postRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PostId " + id + " not found")
        );
    }
}
