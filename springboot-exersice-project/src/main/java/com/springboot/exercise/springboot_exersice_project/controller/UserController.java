package com.springboot.exercise.springboot_exersice_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exercise.springboot_exersice_project.dto.ConfigBean;
import com.springboot.exercise.springboot_exersice_project.dto.GetUserRs;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;
import com.springboot.exercise.springboot_exersice_project.service.UserService;

import jakarta.validation.Valid;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ConfigBean configBean;
    
    @GetMapping("/users")
    public List<GetUserRs> getAllUsers() {
        return userService.getAllUsers();
    }
    
    // TODO: ResponseEntity 放 controller
    @PostMapping("/users")
    public ResponseEntity<GetUserRs> createUser(@Valid @RequestBody UserDetails user) {
        GetUserRs getUserRs = userService.createUser(user);
        return ResponseEntity.created(null).body(getUserRs);
    }

    @GetMapping("/users/{id}")
    public GetUserRs getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }
        
    // TODO: URI 都使用名詞
    // TODO: @RequestParam
    @GetMapping("/users/by-param")
    public GetUserRs getUserByBody(@RequestParam(required = false) String id, @RequestParam(required = false) String name) {
        return userService.getUserByBody(id, name);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/config")
    public ConfigBean getConfig() {
        return configBean;
    }
}
