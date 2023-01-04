package com.furkan.entity;

import java.util.List;

import javax.persistence.*;

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

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "classroom_detail_forstudent",
	joinColumns = @JoinColumn(name ="classroom_id",referencedColumnName = "CLASSROOM_ID"),
	inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "STUDENT_NUMBER")
			)
	private List<Student> student;
	


	
	


	
	
	
}
