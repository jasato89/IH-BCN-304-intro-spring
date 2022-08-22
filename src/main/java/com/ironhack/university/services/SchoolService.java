package com.ironhack.university.services;

import com.ironhack.university.model.School;
import com.ironhack.university.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;



    public List<School> findByName(Optional<String> name, Optional<String> address) {
        if (name.isPresent() && address.isPresent()) {
            return schoolRepository.findAllBySchoolNameContainingAndAddressContaining(name.get(), address.get());
        } else if (name.isPresent()) {
            return schoolRepository.findAllBySchoolNameContaining(name.get());
        } else {
            return schoolRepository.findAll();
        }

    }

    public School findSchoolById(Long id) {
        if (schoolRepository.findById(id).isPresent()) {
            return schoolRepository.findById(id).get();
        }
        return null;
    }

    public School saveSchool(String schoolName, String schoolAddress) {

        School school = new School(schoolName, schoolAddress);
        return schoolRepository.save(school);
    }

    public School addSchool(School school) {
        return schoolRepository.save(school);
    }
}
