package com.furkan.entity;
import java.time.LocalDate;

import javax.persistence.*;


@Entity
public class Attendance {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  private int attendance;
  private LocalDate date;

  // constructor to create a new attendance record with the given information
  public Attendance(Student student, Course course, int attendance, LocalDate date) {
    this.student = student;
    this.course = course;
    this.attendance = attendance;
    this.date = date;
  }

  // getter and setter methods for each field
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }
  public Course getCourse() { return course; }
  public void setCourse(Course course) { this.course = course; }
  public int getAttendance() { return attendance; }
  public void setAttendance(int attendance) { this.attendance = attendance; }
  public LocalDate getDate() { return date; }
  public void setDate(LocalDate date) { this.date = date; }
}

