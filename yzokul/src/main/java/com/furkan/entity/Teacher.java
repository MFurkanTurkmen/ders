package com.furkan.entity;

import java.util.*;

import javax.persistence.*;


@Entity
public class Teacher {
  @Id
  @GeneratedValue
  private Long id;

  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String email;
  private String phone;

  @OneToMany(mappedBy = "teacher")
  private List<Classroom> classrooms;

  // constructor to create a new teacher with the given information
  public Teacher(String firstName, String lastName, String dateOfBirth, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.email = email;
    this.phone = phone;
    this.classrooms = new ArrayList<>();
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
  public void setPhone(String phone) { this.phone = phone; }
  public List<Classroom> getClassrooms() { return classrooms; }
  public void setClassrooms(List<Classroom> classrooms) { this.classrooms = classrooms; }

  // method to add a classroom to the teacher's list of classrooms
  public void addClassroom(Classroom classroom) {
    classrooms.add(classroom);
  }
}
  // method to
