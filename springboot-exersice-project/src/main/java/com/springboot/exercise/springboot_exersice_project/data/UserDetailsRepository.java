package com.springboot.exercise.springboot_exersice_project.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    public Optional<UserDetails> findByName(String name);
}
