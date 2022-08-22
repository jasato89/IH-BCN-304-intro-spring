package com.ironhack.university.repository;

import com.ironhack.university.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    List<School> findAllBySchoolNameContaining(String name);
    List<School> findAllBySchoolNameContainingAndAddressContaining(String name, String address);
}
