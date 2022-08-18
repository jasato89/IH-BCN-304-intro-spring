package com.ironhack.university.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Section {

    @Id
    private String id;
    private String code;
    private Short roomNum;
    private String instructor;
    @ManyToOne
    @JoinColumn(name = "course_code")
    private Course course;

    public Section() {

    }

    public Section(String id, String code, Short roomNum, String instructor) {
        this.id = id;
        this.code = code;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String courseCode) {
        this.code = courseCode;
    }

    public Short getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Short roomNum) {
        this.roomNum = roomNum;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }


}
