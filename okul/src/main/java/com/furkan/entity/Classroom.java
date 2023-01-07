package com.furkan.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLASSROOM_ID")
	private int classroomId;
	
	@NonNull
	@Column(unique = true)
	private String className;

//	@JoinTable(name = "classroom_detail_forstudent",
//	joinColumns = @JoinColumn(name ="classroom_id",referencedColumnName = "CLASSROOM_ID"),
//	inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "STUDENT_NUMBER")
//			)
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "classroom",orphanRemoval = true)
	private List<Student> student;


	public Classroom(List<Student> student) {
		this.student = student;
	}


	public Classroom(@NonNull String className, List<Student> student) {
		super();
		this.className = className;
		this.student = student;
	}
	
	
	


	
	


	
	
	
}
