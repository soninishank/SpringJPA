package com.in28minutes.SpringJPA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// A JPA mandates a default constructor

@Entity
public class Course {

    @Id //This is a primary key
    @GeneratedValue
    private Long Id; // Always each database must have an primary key
    private String name;

    //Generate getters (ID and string ) and setters for string
    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Constructor

    protected Course() // Default constructor with Protected will ensure other class which do not inherit the course will not not the no args constructor
    {
    }

    public Course(String name) {
        this.name = name;
    }


    //toString

    @Override
    public String toString() {
        return "Course{" + "Id=" + Id + ", name='" + name + '\'' + '}';
    }
}
