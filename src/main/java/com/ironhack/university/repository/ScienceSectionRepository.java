package com.ironhack.university.repository;

import com.ironhack.university.model.ScienceSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScienceSectionRepository extends JpaRepository<ScienceSection, String> {
}
