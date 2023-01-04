package com.furkan.entity;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Grade {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  private int grade;
  private LocalDate date;

  // constructor to create a new grade with the given information
  public Grade(Student student, Course course, int grade, LocalDate date) {
    this.student = student;
    this.course = course;
    this.grade = grade;
    this.date = date;
  }

  // getter and setter methods for each field
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }
  public Course getCourse() { return course; }
  public void setCourse(Course course) { this.course = course; }
  public int getGrade() { return grade; }
  public void setGrade(int grade) {this.grade=grade;}
  
}
