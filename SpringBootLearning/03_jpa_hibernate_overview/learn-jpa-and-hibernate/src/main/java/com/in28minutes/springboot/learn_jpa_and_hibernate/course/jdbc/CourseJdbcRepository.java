package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate spingJdbcTemplate;

    private static String INSERT_QUERY1 = """
            INSERT INTO COURSE VALUES (1, 'Learn AWS', 'in28minutes')
            """;

    private static String INSERT_QUERY2 = """
            INSERT INTO COURSE VALUES (?, ?, ?)
            """;

    private static String DELETE_QUERY = """
            DELETE FROM COURSE WHERE id = ?
            """;

    private static String SELECT_QUERY = """
            SELECT * FROM COURSE WHERE id = ?
            """;

    public void insert() {
        spingJdbcTemplate.update(INSERT_QUERY1);
    }

    public void insert(Course course) {
        spingJdbcTemplate.update(INSERT_QUERY2, course.getId(), course.getName(), course.getAuthor());
    }
    
    public void deleteById(long id) {
        spingJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return spingJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
