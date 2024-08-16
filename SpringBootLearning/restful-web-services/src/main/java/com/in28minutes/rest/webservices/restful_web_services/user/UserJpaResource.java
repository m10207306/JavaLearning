package com.in28minutes.rest.webservices.restful_web_services.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restful_web_services.jpa.PostRepository;
import com.in28minutes.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource(UserRepository repository, PostRepository postRepository) {
        this.userRepository = repository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<UserJPA> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{userId}")
    public UserJPA retrieveUser(@PathVariable int userId) {
        Optional<UserJPA> user =  userRepository.findById(userId);

        if (user.isEmpty()) {
            // 處理出錯後的處理以及c顯示的 response 要看 CustomizeResponseEntityExceptionHandler
            throw new UserNotFoundException("id: " + userId);
        }

        return user.get();
    }

    @GetMapping("/jpa/users-hateous/{userId}")
    public EntityModel<UserJPA> retrieveUserHateous(@PathVariable int userId) {
        Optional<UserJPA> user =  userRepository.findById(userId);

        if (user.isEmpty()) {
            // 處理出錯後的處理以及顯示的 response 要看 CustomizeResponseEntityExceptionHandler
            throw new UserNotFoundException("id: " + userId);
        }
        
        /*
         * HAL (JSON Hypertext Application Language)
         * Simple format that gives a consistent and easy way to hyperlink between resources in your API
        */
        EntityModel<UserJPA> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        
        return entityModel;
    }
    
    @DeleteMapping("/jpa/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepository.deleteById(userId);
    }

    @GetMapping("/jpa/users/{userId}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int userId) {
        Optional<UserJPA> user =  userRepository.findById(userId);

        if (user.isEmpty()) {
            // 處理出錯後的處理以及顯示的 response 要看 CustomizeResponseEntityExceptionHandler
            throw new UserNotFoundException("id: " + userId);
        }

        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{userId}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int userId, @RequestBody Post post) {
        Optional<UserJPA> user =  userRepository.findById(userId);

        if (user.isEmpty()) {
            // 處理出錯後的處理以及顯示的 response 要看 CustomizeResponseEntityExceptionHandler
            throw new UserNotFoundException("id: " + userId);
        }

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()   /* 取得當前的 /users 路徑 */
        .path("/{id}")  /* 在 /users 加上 /id */
        .buildAndExpand(savedPost.getId())
        .toUri();

        return ResponseEntity.created(location).build(); 
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<UserJPA> createUser(@Valid @RequestBody UserJPA user) {
        UserJPA savedUser = userRepository.save(user);
        
        // 回傳 201
        // return ResponseEntity.created(null).build(); 
        
        // response 中加入location 的 header, value 是 /users/{新增案件的id}
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()   /* 取得當前的 /users 路徑 */
        .path("/{id}")  /* 在 /users 加上 /id */
        .buildAndExpand(savedUser.getId())
        .toUri();

        return ResponseEntity.created(location).build();
    }
}
