package com.furkan.entity;

import java.util.List;

import javax.persistence.*;

import com.furkan.entity.Enum.EType;

import lombok.*;


@Entity
@AllArgsConstructor
@Data
@RequiredArgsConstructor
@NoArgsConstructor

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STUDENT_NUMBER")
	private int studentNumber;
	
	@Column(nullable = false)
	@NonNull
	private String studentName;
	@NonNull
	private String studentSurname;
	
	private EType type;
	
	@NonNull
	@Column(nullable = false)
	private String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Classroom classroom;

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", studentName=" + studentName + ", studentSurname="
				+ studentSurname + ", password=" + password + "]";
	}

	public Student(String studentName, String studentSurname, EType type, String password, Classroom classroom) {
		super();
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.type = type;
		this.password = password;
		this.classroom = classroom;
	}

	public Student(int studentNumber, String studentName, String studentSurname, EType type, String password) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.type = type;
		this.password = password;
	}
	
	




	

	
	
	
}
