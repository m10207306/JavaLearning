package com.springboot.exercise.springboot_exersice_project.service;

import java.util.List;

import com.springboot.exercise.springboot_exersice_project.dto.GetPostRs;
import com.springboot.exercise.springboot_exersice_project.dto.CreatePostRq;


public interface PostService {

    public List<GetPostRs> getAllPost();
    public GetPostRs getPost(Integer postId);

    public GetPostRs createPost(CreatePostRq body);

    public void deletePost(Integer id);

    public GetPostRs updatePost(Integer id, CreatePostRq body);
    
}
