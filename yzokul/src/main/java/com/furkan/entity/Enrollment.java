package com.furkan.entity;

import javax.persistence.*;


@Entity
public class Enrollment {
	  @Id
	  @GeneratedValue
	  private Long id;

	  @ManyToOne
	  @JoinColumn(name = "student_id")
	  private Student student;

	  @ManyToOne
	  @JoinColumn(name = "course_id")
	  private Course course;

	  private boolean enrolled;
	  private boolean dropped;
	  private boolean withdrawn;

	  // constructor to create a new enrollment with the given information
	  public Enrollment(Student student, Course course) {
	    this.student = student;
	    this.course = course;
	    this.enrolled = true;
	    this.dropped = false;
	    this.withdrawn = false;
	  }

	  // getter and setter methods for each field
	  public Long getId() { return id; }
	  public void setId(Long id) { this.id = id; }
	  public Student getStudent() { return student; }
	  public void setStudent(Student student) { this.student = student; }
	  public Course getCourse() { return course; }
	  public void setCourse(Course course) { this.course = course; }
	  public boolean isEnrolled() { return enrolled; }
	  public void setEnrolled(boolean enrolled) { this.enrolled = enrolled; }
	  public boolean isDropped() { return dropped; }
	  public void setDropped(boolean dropped) { this.dropped = dropped; }
	  public boolean isWithdrawn() { return withdrawn; }
	  public void setWithdrawn(boolean withdrawn) { this.withdrawn = withdrawn; }

	  // method to drop the enrollment
}