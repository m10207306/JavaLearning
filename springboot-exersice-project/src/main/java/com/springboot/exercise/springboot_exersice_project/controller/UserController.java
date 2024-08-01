package com.springboot.exercise.springboot_exersice_project.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.exercise.springboot_exersice_project.data.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.data.PostRepository;
import com.springboot.exercise.springboot_exersice_project.data.UserDetails;
import com.springboot.exercise.springboot_exersice_project.data.UserDetailsRepository;

import jakarta.validation.Valid;

@RestController
public class UserController {
    private UserDetailsRepository userDetailsRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    
    public UserController(UserDetailsRepository userDetailsRepository, PostRepository postRepository,
            CommentRepository commentRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    
    @GetMapping("/users")
    public List<UserDetails> getAllUsers() {
        return userDetailsRepository.findAll();
    }
    
    @PostMapping("/users")
    public ResponseEntity<UserDetails> createUser(@Valid @RequestBody UserDetails user) {
        UserDetails userSaved = userDetailsRepository.save(user);
        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(userSaved.getId())
                            .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}")
    public UserDetails getUser(@PathVariable Integer id) {
        // 想說也不一定要自定義一個 Exception, 就用既有的, 然後改 response body 就好
        return userDetailsRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + id + " not found")
        );
    }
        
    @GetMapping("/users2")
    public UserDetails getUser2(@RequestBody Map<String, Object> body) {
        if (body.containsKey("id")) {
            Integer key = (Integer) body.get("id");
            return userDetailsRepository.findById(key).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + key + " not found")
            );
        }
        else if (body.containsKey("name")) {
            String key = (String) body.get("name");
            return userDetailsRepository.findByName(key).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserName " + key + " not found")
            );
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Search key undefined");
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        if (userDetailsRepository.existsById(id)) {
            userDetailsRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 成功刪除返回 204 No Content
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + id + " not found");
        }
    }
}
