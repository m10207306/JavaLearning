package com.springboot.exercise.springboot_exersice_project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.exercise.springboot_exersice_project.entity.Comment;
import com.springboot.exercise.springboot_exersice_project.entity.Post;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;


@RestController
public class CommentController {
    private UserDetailsRepository userDetailsRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentController(UserDetailsRepository userDetailsRepository, PostRepository postRepository,
            CommentRepository commentRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/comments")
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable Integer id) {
        return commentRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "commentId " + id + " not found")
        );
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> createComment(@RequestBody CommentCreateRequestDTO body) {
        Comment comment = new Comment();

        Integer postId = body.getPostId();
        Post post = postRepository.findById(postId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "postId " + postId + " not found" )
        );
        post.setComment(comment);
        comment.setPost(post);

        comment.setTitle("re:" + post.getTitle());
        comment.setBody(body.getBody());
            
        Comment newComment = commentRepository.save(comment);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/post/{postId}/comment/{commentId}")
        .buildAndExpand(postId, newComment.getId())
        .toUri();

        return ResponseEntity.created(location).body(newComment);
    }
}

class CommentCreateRequestDTO {
    private Integer postId;
    private String body;
    
    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    @Override
    public String toString() {
        return "CommentCreateRequestDTO [postId=" + postId + ", body=" + body + "]";
    }
}


