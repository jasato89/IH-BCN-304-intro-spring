package com.ironhack.university.repository;

import com.ironhack.university.model.Course;
import com.ironhack.university.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {


}
