package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // repository.insert(new Course(1, "Learn AWS JPA!", "in28minutes"));
        // repository.insert(new Course(2, "Learn Azure JPA!", "in28minutes"));
        // repository.insert(new Course(3, "Learn DevOps JPA!", "in28minutes"));

        // repository.deleteById(1);

        // System.out.println(repository.findById(2));
        // System.out.println(repository.findById(3));
    }
}
