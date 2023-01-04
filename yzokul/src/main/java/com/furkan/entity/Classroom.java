package com.furkan.entity;
import java.util.*;

import javax.persistence.*;


@Entity
public class Classroom {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private int capacity;
  private List<Course> courses;
  private Map<Course, List<Student>> students;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  // constructor to create a new classroom with the given information
  public Classroom(String name, int capacity, Teacher teacher) {
    this.name = name;
    this.capacity = capacity;
    this.teacher = teacher;
    this.courses = new ArrayList<>();
    this.students = new HashMap<>();
  }

  // getter and setter methods for each field
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getCapacity() { return capacity; }
  public void setCapacity(int capacity) { this.capacity = capacity; }
  public List<Course> getCourses() { return courses; }
  public void setCourses(List<Course> courses) { this.courses = courses; }
  public Map<Course, List<Student>> getStudents() { return students; }
  public void setStudents(Map<Course, List<Student>> students) { this.students = students; }
  public Teacher getTeacher() { return teacher; }
  public void setTeacher(Teacher teacher) { this.teacher = teacher; }

  // method to add a course to the classroom
  public void addCourse(Course course) {
    courses.add(course);
    students.put(course, new ArrayList<>());
  }

  // method to remove a course from the classroom
  public void removeCourse(Course course) {
    courses.remove(course);
    students.remove(course);
  }

  // method to add a student to a course in the classroom
  public void addStudent(Course course, Student student) {
    List<Student> courseStudents = students.get(course);
    if (courseStudents != null) {
      courseStudents.add(student);
    }
  }

  // method to remove a student from a course in the classroom
  public void removeStudent(Course course, Student student) {
    List<Student> courseStudents = students.get(course);
    if (courseStudents != null) {
      courseStudents.remove(student);
    }
  }
}
