package com.furkan.entity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Lessons {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LESSONS_ID")
	private int lessonsId;
	
	@NonNull
	private String lessonName;
	
	@OneToMany(targetEntity = Teacher.class,mappedBy = "lessons")
//	@JoinTable(name="lessons_detain_forteacher",
//	joinColumns = @JoinColumn(name ="lessons_id",referencedColumnName = "LESSONS_ID"),
//	inverseJoinColumns = @JoinColumn(name="teacher_id",referencedColumnName = "TEACHER_ID")
//			)
	@Column(nullable = false)
	private List<Teacher> teacher;


	
	

}