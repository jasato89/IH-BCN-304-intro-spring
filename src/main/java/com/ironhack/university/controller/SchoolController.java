package com.ironhack.university.controller;

import com.ironhack.university.model.School;
import com.ironhack.university.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    SchoolRepository schoolRepository;

    @GetMapping("/schools/")
    @ResponseStatus(HttpStatus.OK)
    private List<School> findAllSchools() {
        return  schoolRepository.findAll();
    }

    @RequestMapping(value = "/schools/{id}", method = RequestMethod.GET)
    private School findSchoolById(@PathVariable Long id) {
        return schoolRepository.findById(id).get();

    }

    @GetMapping("/save-school/{school-name}/{school-address}")
    private School saveSchool(@PathVariable(name = "school-name") String schoolName,
                              @PathVariable(name = "school-address") String schoolAddress) {
        School school = new School(schoolName, schoolAddress);
        return schoolRepository.save(school);

    }


    @PostMapping("/schools")
    @ResponseStatus(HttpStatus.CREATED)
    private School addSchool(@RequestBody School school) {
        return schoolRepository.save(school);
    }
}
