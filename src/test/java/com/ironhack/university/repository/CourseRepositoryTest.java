package com.ironhack.university.repository;

import com.ironhack.university.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @AfterEach
    void tearDown() {
        courseRepository.deleteAll();
    }

    @Test
    public void addNewCourse() {
        Course course = new Course("CS105", "Intro to SpringBoot and JPA");
        // A comment.
        // INSERT INTO course (course_code, course_name) VALUES course.getCourseCode, course.getCourseName
        courseRepository.save(course);
        Optional<Course> result = courseRepository.findById("CS105");
        assertTrue(result.isPresent());
        assertEquals(course, result.get());

        courseRepository.findAll();
        courseRepository.delete(course);
        course.setCourseName("Intro to springboot");
        courseRepository.save(course);





    }

}
