package com.furkan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Student {
  @Id
  @GeneratedValue
  private Long id;

  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String email;
  private String phone;
  private boolean enrolled;

  @ManyToMany(mappedBy = "students")
  private List<Classroom> classrooms;

  @OneToMany(mappedBy = "student")
  private List<Enrollment> enrollments;

  @OneToMany(mappedBy = "student")
  private Map<Course, List<Integer>> grades;



  // constructor to create a new student with the given information
  public Student(String firstName, String lastName, String dateOfBirth, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.email = email;
    this.phone = phone;
    this.enrolled = true;
    this.classrooms = new ArrayList<>();
    this.enrollments = new ArrayList<>();
    this.grades = new HashMap<>();
  }

  // getter and setter methods for each field
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }
  public String getDateOfBirth() { return dateOfBirth; }
  public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getPhone() { return phone; }
  public void setPhone(String phone) { this.phone=phone;}
  
}

