package com.furkan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private int studentNumber;
	private String studentName;
	private String studentSurname;
	private int exam;
	private int finalExam;
}
