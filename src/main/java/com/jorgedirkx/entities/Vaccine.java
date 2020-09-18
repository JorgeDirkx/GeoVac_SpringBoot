package com.jorgedirkx.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int type;

    @OneToMany(mappedBy = "vaccine")
    private Set<Registration>registrations = new HashSet<>();



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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}