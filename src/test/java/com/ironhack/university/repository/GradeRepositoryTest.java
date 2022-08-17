package com.ironhack.university.repository;

import com.ironhack.university.model.Grade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GradeRepositoryTest {
    private Grade grade1;
    private Grade grade2;
    private Grade grade3;
    private Grade grade4;
    private Grade grade5;

    @Autowired
    GradeRepository gradeRepository;

    @BeforeEach
    void setUp() {
        grade1 = new Grade("Aldo Santa Maria", "CS101-A", 75);
        grade2 = new Grade("Raúl Galán", "CS101-A", 80);
        grade3 = new Grade("Gerard", "CS101-A", 60);
        grade4 = new Grade("Alessio", "CS101-A", 90);
        grade5 = new Grade("Nil", "CS101-A", 75);
        //gradeRepository.saveAll(List.of(grade1, grade2, grade3, grade4, grade5));
    }

    @AfterEach
    void tearDown() {
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


    @Test
    void findByStudentNameAndSectionId() {
        Optional<Grade> expected = gradeRepository
                .findByStudentNameAndSectionId("Aldo Santa Maria","CS101-A");

        assertTrue(expected.isPresent());
        assertEquals(grade1.getStudentName(), expected.get().getStudentName());

        expected = gradeRepository
                // Checking that the method returns an empty Optional when the student name and section id are not found.
                .findByStudentNameAndSectionId("Aldo Santa Maria","CS101-B");
        assertFalse(expected.isPresent());

        expected = gradeRepository
                .findByStudentNameAndSectionId("Lado Santa Maria","CS101-A");

        assertFalse(expected.isPresent());

    }

    @Test
    void findByStudentName() {
        Grade grade = gradeRepository.findByStudentName("Aldo Santa Maria");

        assertEquals("Aldo Santa Maria", grade.getStudentName());

        grade = gradeRepository.findByStudentName("Pepe");

        assertEquals(null, grade);

    }

    @Test
    void findScoreBetween() {
        List<Grade> grades = gradeRepository.findByScoreBetween(50, 76);

        for (Grade grade : grades) {
            System.out.println(grade.getStudentName());
        }

        assertEquals(3, grades.size());

        grades = gradeRepository.findByScoreBetween(89, 91);
        assertEquals(1, grades.size());

        grades = gradeRepository.findByScoreGreaterThan(95);
        assertEquals(0, grades.size());


    }

    @Test
    void findAverageBySection() {

        List<Object[]> expected = gradeRepository.findAverageBySection();

        assertEquals("CS101-A", expected.get(0)[0]);

    }

    @Test
    void findAverageBySectionId() {
        Double expected = gradeRepository.findAverageBySection("CS101-B");
        assertEquals(70.0, expected);
    }

    @Test
    void findStudentsWithAnAverageLower() {
        List<Object[]> expected = gradeRepository.findStudentNameAndAvgScoreLowerThan(75.0);
        assertEquals("Gerard", expected.get(0)[0]);
        assertEquals(67.5, expected.get(0)[1]);

    }
}
