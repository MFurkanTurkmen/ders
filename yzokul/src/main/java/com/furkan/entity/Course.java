package com.furkan.entity;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String description;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  @ManyToOne
  @JoinColumn(name = "classroom_id")
  private Classroom classroom;

  // Constructors, getters, and setters go here
}

