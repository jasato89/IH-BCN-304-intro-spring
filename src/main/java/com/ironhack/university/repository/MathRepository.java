package com.ironhack.university.repository;

import com.ironhack.university.model.MathSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MathRepository extends JpaRepository<MathSection, String> {
}
