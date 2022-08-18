package com.ironhack.university.repository;

import com.ironhack.university.model.Faculty;
import com.ironhack.university.model.Office;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FacultyRepositoryTest {
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    FacultyRepository facultyRepository;

    Office office;
    Faculty faculty;

    @BeforeEach
    void init() {
        office = officeRepository.save(new Office(10, "Building East"));
        faculty = facultyRepository.save(
                new Faculty("Facultad 1", "Facultad Guay", "Department 1", true, office));
    }

    @AfterEach
    void tearDown() {
        facultyRepository.deleteAll();
        officeRepository.deleteAll();
    }

    @Test
    void checkQuery() {

        assertTrue(facultyRepository.findByOfficeRoomNumber(10).isPresent());

    }
}
