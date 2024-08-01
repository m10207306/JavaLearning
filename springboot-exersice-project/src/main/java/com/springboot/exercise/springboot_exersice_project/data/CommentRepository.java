package com.springboot.exercise.springboot_exersice_project.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<UserDetails, Integer> {

}
