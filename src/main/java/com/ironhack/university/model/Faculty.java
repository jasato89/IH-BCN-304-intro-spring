package com.ironhack.university.model;

import javax.persistence.*;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String department;
    private boolean tenure;
    @OneToOne
    @JoinColumn(name = "office_id")
    private Office office;

    public Faculty() {
    }

    public Faculty(String firstName, String lastName, String department, boolean tenure, Office office) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.tenure = tenure;
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isTenure() {
        return tenure;
    }

    public void setTenure(boolean tenure) {
        this.tenure = tenure;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
