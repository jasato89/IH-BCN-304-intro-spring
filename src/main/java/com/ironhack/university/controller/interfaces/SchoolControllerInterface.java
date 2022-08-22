package com.ironhack.university.controller.interfaces;

import com.ironhack.university.controller.SchoolController;
import com.ironhack.university.model.School;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface SchoolControllerInterface {

     List<School> findByName(Optional<String> name, Optional<String> address);
    School findSchoolById( Long id);
    School saveSchool(String schoolName, String schoolAddress);
    School addSchool(School school);
}
