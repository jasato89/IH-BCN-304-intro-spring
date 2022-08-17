package com.ironhack.university.repository;

import com.ironhack.university.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    //SELECT * FROM grade WHERE student_name = :studentName and section_id = :section_id;
    Optional<Grade> findByStudentNameAndSectionId(String studentName, String sectionId);
    Grade findByStudentName(String studentName);
    List<Grade> findAllByStudentNameContaining(String studentName);
    List<Grade> findByScoreBetween(Integer min, Integer max);
    List<Grade> findByScoreGreaterThan(Integer min);


    @Query("SELECT sectionId, AVG(score) from Grade GROUP BY sectionId")
    List<Object[]> findAverageBySection();

    @Query("SELECT AVG (score) from Grade WHERE sectionId = :section GROUP BY sectionId")
    Double findAverageBySection(String section);


}
