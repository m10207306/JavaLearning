package com.springboot.exercise.springboot_exersice_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.exercise.springboot_exersice_project.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
