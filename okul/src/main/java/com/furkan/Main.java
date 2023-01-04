package com.furkan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.furkan.entity.*;
import com.furkan.repository.ClassroomDao;
import com.furkan.repository.StudentDao;

public class Main {
	
	
	
	public static void main(String[] args) {
		ClassroomDao classroomDao = new ClassroomDao();
		StudentDao studentDao = new StudentDao();
		
//		
//		
//		Classroom classroom = new Classroom("12-b");
//		Student st = new Student("semra", "türkmen", "smrt2314", classroom);
//		Student st2 = new Student("furkan", "türkmen", "frkntrkmn123", classroom);
//		Student st3 = new Student("şükrü", "türkmen", "skr1965", classroom);
//		Student st4 = new Student("mehmet", "vurankaçık", "işlxase2!!-=sax", classroom);
//		Student st5 = new Student("gamze", "topla", "tplgmze1123", classroom);
//
//		List<Student> studentList = new ArrayList<>();
//		studentList.add(st);
//		studentList.add(st2);
//		studentList.add(st3);
//		studentList.add(st4);
//		studentList.add(st5);
//
//
//		classroom.setStudent(studentList);
//		
//		studentDao.save(st);
//		studentDao.save(st2);
//		studentDao.save(st3);
//		studentDao.save(st4);
//		studentDao.save(st5);
//
//		classroomDao.save(classroom);
//		
//		
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		for(Classroom uye : classroomDao.findAll()){
		System.out.println("classroom id : "+uye.getClassroomId()+", sınıf adi: "+uye.getClassName()+uye.getStudent().stream().map(obj -> Objects.toString("ogrenci no : "+obj.getStudentNumber()+", ogrenci adi: "+obj.getStudentName()+", soyad: "+obj.getStudentSurname()+"\n")).toList());
	}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");



		
}







}// class