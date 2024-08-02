package com.springboot.exercise.springboot_exersice_project.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;

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

    @GetMapping("/posts")
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{postId}")
    public Post getPost(@PathVariable Integer postId) {
        return postRepository.findById(postId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "postId " + postId + " not found")
        );
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody PostCreateDTO body) {
        Post post = new Post();
        post.setTitle(body.getTitle());
        post.setBody(body.getBody());

        Integer userId = body.getUserId();
        UserDetails userDetails = userDetailsRepository.findById(userId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found" )
        );
        post.setUserDetails(userDetails);
        post.setComment(null);
        
        Post newPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/user/{userId}/post/{postId}")
        .buildAndExpand(userId, newPost.getId())
        .toUri();

        return ResponseEntity.created(location).body(newPost); 
    }
}

class PostCreateDTO {
    private Integer userId;
    private String title;
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
}

class PostGetDTO {
    
}
