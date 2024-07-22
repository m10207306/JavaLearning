package com.in28minutes.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{userId}")
    public User retrieveUser(@PathVariable int userId) {
        User user =  service.findOne(userId);
        if (user == null) {
            // 處理出錯後的處理以及顯示的 response 要看 CustomizeResponseEntityExceptionHandler
            throw new UserNotFoundException("id: " + userId);
        }
        return user;
    }
    
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        service.deleteOne(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.saveUser(user);
        
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
