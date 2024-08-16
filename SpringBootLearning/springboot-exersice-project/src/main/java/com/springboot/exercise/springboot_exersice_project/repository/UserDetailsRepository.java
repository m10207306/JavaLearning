package com.springboot.exercise.springboot_exersice_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.exercise.springboot_exersice_project.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    public Optional<UserDetails> findByName(String name);
}
