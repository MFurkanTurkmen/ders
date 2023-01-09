package com.furkan.entity;

import java.util.List;

import javax.persistence.*;

import com.furkan.entity.Enum.EType;

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
	
	private EType type;
	
	@NonNull
	private String mail;
	
	@NonNull
	private String password;
	

	@ManyToMany
//	@JoinTable(name = "teacher_detail_forclassroom",
//	joinColumns = @JoinColumn(name="teacher_id",referencedColumnName = "TEACHER_ID"),
//	inverseJoinColumns = @JoinColumn(name="classroom_id",referencedColumnName = "CLASSROOM_ID")
//			)
	private List<Classroom> classroom;
	
	@ManyToMany
//	@JoinTable(name = "teacher_detail_forstudent",
//	joinColumns = @JoinColumn(name="teacher_id",referencedColumnName = "TEACHER_ID"),
//	inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "STUDENT_NUMBER")
//			)
	@Column(nullable = false)
	private List<Student> student;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Lessons lessons;

	public Teacher(String teacherName, String teacherSurname, EType type, String mail, String password) {
		super();
		this.teacherName = teacherName;
		this.teacherSurname = teacherSurname;
		this.type = type;
		this.mail = mail;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSurname=" + teacherSurname
				+ ", type=" + type + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
	
	
	
	
	

}
