package com.ironhack.university.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "welcome_pack_id")
    private WelcomePack welcomePack;

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

    public Student(String firstName, String lastName, WelcomePack welcomePack) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.welcomePack = welcomePack;
    }

    public Student(String firstName, String lastName, WelcomePack welcomePack, Address primaryAddress, Address postalAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryAddress = primaryAddress;
        this.welcomePack = welcomePack;
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

    public WelcomePack getWelcomePack() {
        return welcomePack;
    }

    public void setWelcomePack(WelcomePack welcomePack) {
        this.welcomePack = welcomePack;
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
