package com.springboot.exercise.springboot_exersice_project.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.repository.CommentRepository;
import com.springboot.exercise.springboot_exersice_project.repository.PostRepository;
import com.springboot.exercise.springboot_exersice_project.repository.UserDetailsRepository;

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
    public List<UserGetDTO> getAllUsers() {
        // return userDetailsRepository.findAll();
        
        List<UserDetails> userDetails = userDetailsRepository.findAll();

        return userDetails.stream()
                        .map(user -> {
                            UserGetDTO userGetDTO = new UserGetDTO();
                            userGetDTO.setId(user.getId());
                            userGetDTO.setBirthDate(user.getBirthDate());
                            userGetDTO.setName(user.getName());

                            List<Integer> postIds = user.getPosts().stream()
                                                                .map(post -> post.getId())
                                                                .collect(Collectors.toList());
                            userGetDTO.setPosts(postIds);

                            return userGetDTO;
                        }).collect(Collectors.toList());
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
        
    @GetMapping("/get-user-by-body")
    public UserDetails getUserByBody(@RequestBody Map<String, Object> body) {
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Search key undefined");
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

class UserGetDTO {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private List<Integer> posts;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public List<Integer> getPosts() {
        return posts;
    }
    public void setPosts(List<Integer> posts) {
        this.posts = posts;
    }
    @Override
    public String toString() {
        return "UserGetDTO [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", posts=" + posts + "]";
    }
}
