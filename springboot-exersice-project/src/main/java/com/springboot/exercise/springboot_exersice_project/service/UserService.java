package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.springboot.exercise.springboot_exersice_project.dto.UserGetDto;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;


public interface UserService {

    public List<UserGetDto> getAllUsers();
    public UserGetDto getUser(Integer id);
    public UserGetDto getUserByBody(Map<String, Object> body);

    public ResponseEntity<UserGetDto> createUser(UserDetails user);

    public ResponseEntity<Void> deleteUser(Integer id);
    
}
