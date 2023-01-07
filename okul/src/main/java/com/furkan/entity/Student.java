package com.furkan.entity;

import javax.persistence.*;

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
	@NonNull
	@Column(nullable = false)
	private String password;
	
	@ManyToOne
	@NonNull
	private Classroom classroom;

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", studentName=" + studentName + ", studentSurname="
				+ studentSurname + ", password=" + password + ", classroom=" + classroom.getClassName() + "]";
	}


	
	
	
}
