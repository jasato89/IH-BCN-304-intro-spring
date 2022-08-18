package com.ironhack.university.repository;

import com.ironhack.university.model.Course;
import com.ironhack.university.model.Section;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SectionRepository sectionRepository;

    @AfterEach
    void tearDown() {
/*

        courseRepository.deleteAll();
        sectionRepository.deleteAll();
 */

    }

    @Test
    public void addNewCourse() {
        Course course = new Course("CS105", "Intro to SpringBoot and JPA", new ArrayList<>());
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

    @Test
    void checkRelationshipWorks() {

        Course course = courseRepository.save(
                new Course("CS105", "Intro to SpringBoot and JPA", new ArrayList<>())
        );
        Section section1 = new Section("Section-01", "1001-A", (short) 25, "Ale");
        Section section2 = new Section("Section-02", "1002-A", (short) 32, "Jose");
        Section section3 = new Section("Section-03", "1003-B", (short) 1, "Jaume");

        section1.setCourse(course);
        section2.setCourse(course);
        section3.setCourse(course);

        List<Section> sections = sectionRepository.saveAll(
                List.of(section1, section2, section3)
        );

        course.setSections(sections);
        List<Section> sections1 = sectionRepository.findByCourse(course);

        assertEquals(3, sections1.size());

    }

}
