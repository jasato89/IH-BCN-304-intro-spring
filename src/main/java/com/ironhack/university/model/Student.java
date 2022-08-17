package com.ironhack.university.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Embedded
    private Address primaryAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="streetAddress", column = @Column(name = "postal_street_address")),
            @AttributeOverride(name="city", column = @Column(name = "postal_city")),
            @AttributeOverride(name="postalCode", column = @Column(name = "postal_postalCode"))
    })
    private Address postalAddress;
    //Primary address
    //Postal Address

    public Student() {
    }

    public Student(String firstName, String lastName, Address primaryAddress, Address postalAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryAddress = primaryAddress;
        this.postalAddress = postalAddress;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
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
}
