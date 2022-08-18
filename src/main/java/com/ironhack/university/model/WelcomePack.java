package com.ironhack.university.model;

import javax.persistence.*;

@Entity
public class WelcomePack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String welcomeMessage;
    private String tShirtSize;
    @OneToOne(mappedBy = "welcomePack")
    private Student student;


    public WelcomePack() {
    }

    public WelcomePack(String welcomeMessage, String tShirtSize) {
        this.welcomeMessage = welcomeMessage;
        this.tShirtSize = tShirtSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String gettShirtSize() {
        return tShirtSize;
    }

    public void settShirtSize(String tShirtSize) {
        this.tShirtSize = tShirtSize;
    }
}
