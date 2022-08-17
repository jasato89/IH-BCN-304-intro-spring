package com.ironhack.university.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class ScienceSection extends Section{
    private final int numberOfLabHours;
    private String labRoom;

    public ScienceSection(String courseCode, Short roomNum, String instructor, int numberOfLabHours, String labRoom) {
        super(courseCode, roomNum, instructor);
        this.numberOfLabHours = numberOfLabHours;
        this.labRoom = labRoom;
    }

    public ScienceSection() {
        numberOfLabHours = 30;
    }

    public int getScienceCredits() {
        return numberOfLabHours;
    }
}
