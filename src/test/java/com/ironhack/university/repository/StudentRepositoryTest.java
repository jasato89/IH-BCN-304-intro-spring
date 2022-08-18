package com.ironhack.university.repository;

import com.ironhack.university.model.Address;
import com.ironhack.university.model.Assignment;
import com.ironhack.university.model.Student;
import com.ironhack.university.model.WelcomePack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    WelcomePackRepository welcomePackRepository;
    @Autowired
    AssignmentRepository assignmentRepository;



    @Test
    void checkAssignments() {

        List<Assignment> assignments =
                            assignmentRepository.saveAll(
                                    List.of(
                                            new Assignment("Java 306", "18/Agosto", new ArrayList<>()),
                                            new Assignment("Java 308", "19/Agosto", new ArrayList<>())
                                    )
                            );

        WelcomePack welcomePack = welcomePackRepository.save(new WelcomePack("Hola", "M"));
        Student student = studentRepository.save(
                new Student("Nil", "Soriano",
                        welcomePack,
                        assignments, new Address(), new Address())
        );

        assertTrue(studentRepository.findById(1l).isPresent());

        assertEquals(2, studentRepository.findAll().get(0).getAssignments().size());

    }



    @Test
    void relationshipWorks() {

       assertEquals("Marc", studentRepository.findAll().get(0).getFirstName());
    }

    @Test
    void checkWelcomePack() {

        Student student = studentRepository.findAll().get(0);

        WelcomePack welcomePack = student.getWelcomePack();

        assertEquals("M", welcomePack.gettShirtSize());

        Student student1 =welcomePack.getStudent();

        assertEquals(student.getFirstName(), student1.getFirstName());
    }

}
