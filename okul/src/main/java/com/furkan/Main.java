package com.furkan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.furkan.entity.*;
import com.furkan.repository.ClassroomDao;
import com.furkan.repository.StudentDao;
import com.furkan.repository.myRepo.MyClassroomRepository;
import com.furkan.repository.myRepo.MyCrud;
import com.furkan.repository.myRepo.MyICrud;
import com.furkan.repository.myRepo.MyStudentRepository;

public class Main {
	
	
	
	public static void main(String[] args) {

		ClassroomDao clDao = new ClassroomDao();
		StudentDao stDao = new StudentDao();
		
//		----KAYIT ATMA-----
//		Classroom classroom1= new Classroom("sarac2 sınıfı");
//		Classroom classroom2= new Classroom("yilmazer2 sınıfı");
//		Classroom classroom3= new Classroom("türkmen2 sınıfı");
		Student studentilay = new  Student("yeni denizcik", "sarac", "asd123", clDao.findById(4));
//		Student studentmuh = new  Student("m2uhammet", "sarac", "123asd", classroom1);
//		Student studentdeniz = new  Student("d2eniz", "sarac", "a1s2d3", classroom1);
//		Student studentonur = new  Student("o2nur", "yilmazer", "asd123", classroom2);
//		Student studentdol = new  Student("do2lunay", "yilmazer", "123asd", classroom2);
//		Student studentduru = new  Student("d2uru", "yilmazer", "a1s2d3", classroom2);		
//		Student studentfrkn = new  Student("f2urkan", "trkmn", "asd123", classroom3);
//		Student studentsükrü = new  Student("ş2ükrü", "trkmn", "123asd", classroom3);
//		Student studentsemra = new  Student("s2emra", "trkmn", "a1s2d3", classroom3);
//		clDao.save(classroom1);
//		clDao.save(classroom2);
//		clDao.save(classroom3);
//
//		stDao.save(studentilay);
//		stDao.save(studentmuh);
//		stDao.save(studentdeniz);
//		stDao.save(studentonur);
//		stDao.save(studentdol);
//		stDao.save(studentduru);
//		stDao.save(studentfrkn);
//		stDao.save(studentsükrü);
//		stDao.save(studentsemra);

//		---- UPDATE ETME---
//		Student studentsemra = new  Student("semra", "türkmen", "semrasifresi",clDao.findById(3));
//		stDao.update(9, studentsemra);
//		Classroom classroom3= new Classroom("TURKMEN AILESI");
//		clDao.update(3, classroom3);

//		---- FIND ALL ----		
//		System.out.println(stDao.findAll());
//		System.out.println(clDao.findAll());
		
//		---FIND BY ID---
//		System.out.println(stDao.findById(2));
//		System.out.println(clDao.findById(3));
		
//		---- FIND BY NAME----
//		System.out.println(stDao.findByName("duru"));
//		System.out.println(clDao.findByName("sarac sınıfı"));

//		--- OPTIONAL FIND BY NAME---
//		System.out.println(stDao.findByNameOptional("deniz"));
//		System.out.println(clDao.findByNameOptional("TURKMEN AILESI"));
		
		//stDao.delete(16);
		//clDao.delete(3);
		
	//	stDao.update(clDao.findById(6), 10);
		//stDao.update(10, studentilay);
		
		MyCrud<Student> studentRepository= new MyStudentRepository();
		MyCrud<Classroom> classRepository= new MyClassroomRepository();
		
//		System.out.println("-->"+studentRepository.findAll(Student.class));
//		System.out.println("-->"+classRepository.findAll(Classroom.class));
		
		System.out.println("-->"+studentRepository.findById(Student.class, 15));
		
		
		
		
		
}







}// class