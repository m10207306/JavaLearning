package com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Spring Data JPA!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Spring Data JPA!", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps Spring Data JPA!", "in28minutes"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
    }
}
