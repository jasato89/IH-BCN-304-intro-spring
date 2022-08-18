package com.ironhack.university.repository;

import com.ironhack.university.model.Course;
import com.ironhack.university.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {

    List<Section> findByCourse(Course course);

}
