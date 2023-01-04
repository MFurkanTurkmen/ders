package com.furkan.entity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TEACHER_ID")
	private int teacherId;
	
	@NonNull
	private String teacherName;
	
	private String teacherSurname;
	
	@NonNull
	private String mail;
	
	@NonNull
	private String password;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_detail_forclassroom",
	joinColumns = @JoinColumn(name="teacher_id",referencedColumnName = "TEACHER_ID"),
	inverseJoinColumns = @JoinColumn(name="classroom_id",referencedColumnName = "CLASSROOM_ID")
			)
	private List<Classroom> classroom;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_detail_forstudent",
	joinColumns = @JoinColumn(name="teacher_id",referencedColumnName = "TEACHER_ID"),
	inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "STUDENT_NUMBER")
			)
	private List<Student> student;
	
	@ManyToOne(optional = false,targetEntity = Lessons.class)
	@JoinColumn(name="lessons_id",referencedColumnName = "LESSONS_ID")
	private Lessons lessons;
	
	
	

}
