package com.springboot.exercise.springboot_exersice_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.exercise.springboot_exersice_project.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
