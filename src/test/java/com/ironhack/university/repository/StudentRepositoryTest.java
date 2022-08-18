package com.ironhack.university.repository;

import com.ironhack.university.model.Address;
import com.ironhack.university.model.Student;
import com.ironhack.university.model.WelcomePack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    WelcomePackRepository welcomePackRepository;



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
