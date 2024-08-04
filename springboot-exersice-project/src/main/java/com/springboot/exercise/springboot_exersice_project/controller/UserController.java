package com.springboot.exercise.springboot_exersice_project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exercise.springboot_exersice_project.dto.UserGetDto;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.service.UserServiceImp;

import jakarta.validation.Valid;


@RestController
public class UserController {
    @Autowired
    private UserServiceImp userService;
    
    @GetMapping("/users")
    public List<UserGetDto> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/users")
    public ResponseEntity<UserGetDto> createUser(@Valid @RequestBody UserDetails user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public UserGetDto getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }
        
    @GetMapping("/get-user-by-body")
    public UserGetDto getUserByBody(@RequestBody Map<String, Object> body) {
        return userService.getUserByBody(body);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
