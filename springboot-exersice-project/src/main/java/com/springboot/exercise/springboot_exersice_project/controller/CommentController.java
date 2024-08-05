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

import com.springboot.exercise.springboot_exersice_project.dto.GetCommentRs;
import com.springboot.exercise.springboot_exersice_project.dto.CreateCommentRq;
import com.springboot.exercise.springboot_exersice_project.service.CommentService;


@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public List<GetCommentRs> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/comments/{id}")
    public GetCommentRs getComment(@PathVariable Integer id) {
        return commentService.getComment(id);
    }

    @PostMapping("/comments")
    public ResponseEntity<GetCommentRs> createComment(@RequestBody CreateCommentRq body) {
        return ResponseEntity.created(null).body(commentService.createComment(body));
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<GetCommentRs> updateComment(@PathVariable Integer id, @RequestBody CreateCommentRq body) {
        return ResponseEntity.ok().body(commentService.updateComment(id, body));
    }
}
