package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;

import com.springboot.exercise.springboot_exersice_project.dto.GetUserRs;
import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;


public interface UserService {

    public List<GetUserRs> getAllUsers();
    public GetUserRs getUser(Integer id);
    public GetUserRs getUserByBody(String id, String name);

    public GetUserRs createUser(UserDetails user);

    public void deleteUser(Integer id);
    
}
