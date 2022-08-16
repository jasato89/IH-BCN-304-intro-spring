package com.ironhack.university.repository;

import com.ironhack.university.model.Grade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GradeRepositoryTest {
    private Grade grade1;
    private Grade grade2;

    @Autowired
    GradeRepository gradeRepository;

    @BeforeEach
    void setUp() {
        grade1 = new Grade("Aldo Santa Maria", "CS101-A", 75);
        grade2 = new Grade("Raúl Galán", "CS101-A", 80);
        gradeRepository.save(grade1);
        gradeRepository.save(grade2);
    }

    @AfterEach
    void tearDown() {
        gradeRepository.deleteAll();
    }

    @Test
    void testFindAll() {
        List<Grade> result = gradeRepository.findAll();
        assertEquals(2, result.size());
    }
    @Test
    void setUpdateTest() {

        grade1.setScore(82);
        gradeRepository.save(grade1);

        Grade grade = gradeRepository.findAll().get(0);
        assertEquals(82, grade.getScore());
    }

    @Test
    void testDelete() {
        gradeRepository.delete(grade1);
        List<Grade> result  = gradeRepository.findAll();

        assertEquals(1, result.size());
    }
}
