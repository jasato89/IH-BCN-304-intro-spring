package com.ironhack.university.model;

import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.util.List;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String assignmentName;
    private String dueDate;
    @ManyToMany(mappedBy = "assignments")
    private List<Student> students;

    public Assignment(String assignmentName, String dueDate, List<Student> students) {
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
        this.students = students;
    }

    public Assignment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
