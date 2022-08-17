package com.ironhack.university.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class MathSection extends Section {
    private final int mathCredits;

    public MathSection() {
        this.mathCredits = 0;
    }

    public MathSection(String courseCode, Short roomNum, String instructor, int mathCredits) {
        super(courseCode, roomNum, instructor);
        this.mathCredits = mathCredits;
    }

    public int getMathCredits() {
        return mathCredits;
    }
}
