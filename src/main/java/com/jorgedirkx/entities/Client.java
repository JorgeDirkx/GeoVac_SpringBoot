package com.jorgedirkx.entities;

import jdk.jfr.DataAmount;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "client")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "Date_of_Birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateofbirth;
    @Column(name = "PassportNR")
    private String passportNr;
    private String gender;

    @OneToMany(mappedBy = "vaccine")
    private Set<Registration>registrations = new HashSet<>();


    public Client() {
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client (int id, String name, Date dateofbirth, String passportNr, String gender){
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.passportNr = passportNr;
        this.gender = gender;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPassportNr() {
        return passportNr;
    }

    public void setPassportNr(String passportNr) {
        this.passportNr = passportNr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dateofbirth +
                ", passportNr='" + passportNr + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
