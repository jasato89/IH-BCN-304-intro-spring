package com.ironhack.university.repository;

import com.ironhack.university.model.WelcomePack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WelcomePackRepository extends JpaRepository<WelcomePack, Long> {
}
