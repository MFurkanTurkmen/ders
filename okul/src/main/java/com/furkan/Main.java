package com.furkan;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.entity.Classroom;
import com.furkan.entity.Lessons;
import com.furkan.entity.Student;
import com.furkan.entity.Teacher;
import com.furkan.entity.UserEntity;
import com.furkan.entity.Enum.EType;
import com.furkan.repository.ClassroomDao;
import com.furkan.repository.LessonsDao;
import com.furkan.repository.StudentDao;
import com.furkan.repository.TeacherDao;
import com.furkan.util.HibernateUtils;

public class Main {
	Session session = null;
	Transaction transaction;
	public void openSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	
	public void closeSession() {
		transaction.commit();
		session.close();

	}

	
	public void closeRollBack() {
		transaction.rollback();
		session.close();

	}


	
	public static void main(String[] args) {

		ClassroomDao clDao = new ClassroomDao();
		StudentDao stDao = new StudentDao();
		TeacherDao teacherDao = new TeacherDao();
		LessonsDao lessonsDao = new LessonsDao();
		
		//----KAYIT ATMA-----
//		Classroom classroom1= new Classroom("bekar sınıfı");
//		Classroom classroom2= new Classroom("yilmazer sınıfı");
//		Classroom classroom3= new Classroom("türkmen sınıfı");
//	
//		
//		Student studentilay = new  Student("ilay2","sarac",EType.STUDENT,"1928347",classroom1);
//		Student studentmuh = new  Student("muhammet", "sarac",EType.STUDENT, "123asd", classroom1);
//		Student studentdeniz = new  Student("deniz", "sarac",EType.STUDENT, "a1s2d3", classroom1);
//		Student studentonur = new  Student("onur", "yilmazer",EType.STUDENT, "asd13", classroom2);
//		Student studentdol = new  Student("dolunay", "yilmazer",EType.STUDENT, "13asd", classroom2);
//		Student studentduru = new  Student("duru", "yilmazer",EType.STUDENT, "a1s2d3", classroom2);		
//		Student studentfrkn = new  Student("furkan", "trkmn",EType.STUDENT, "asd123", classroom3);
//		Student studentsükrü = new  Student("şükrü", "trkmn",EType.STUDENT, "123asd", classroom3);
//		Student studentsemra = new  Student("semra", "trkmn",EType.STUDENT, "a1sd3", classroom3);
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
//		
		//clDao.delete(6);
//

//		
//		
//		---- UPDATE ETME---
//		Student studentsemra = new  Student("düzenlendiSEMRA", "Bekar", EType.TEACHER,"smrr",clDao.findById(9));
//		stDao.update(30, studentsemra);
//		Classroom classroom3= new Classroom("düzenlendiiTURKMEN AILESI");
//		clDao.update(10, classroom3);

	//	---- FIND ALL ----		
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
		

		
		
		
//		Lessons lessons= new Lessons("beden");
//		lessonsDao.save(lessons);
//
//		Teacher teacher = new Teacher("yasemin", "büyük", "12345");
		//teacherDao.save(teacher);
		
//		teacherDao.update(6, lessonsDao.findById(6));
//		teacherDao.update(7, lessonsDao.findById(6));
//		teacherDao.update(8, lessonsDao.findById(5));
//		teacherDao.update(9, lessonsDao.findById(5));
		
	//	lessonsDao.delete(5);

		
	//	teacherDao.delete(5);
		
//		teacherDao.update(3, clDao.findById(2));
//		teacherDao.update(5, clDao.findById(2));
//		teacherDao.update(2, clDao.findById(1));
//		teacherDao.update(2, clDao.findById(3));

	//	teacherDao.delete(2);

		//System.out.println(teacherDao.findAll());
		//System.out.println(teacherDao.findById(3));
		//System.out.println(teacherDao.findByName("ay"));
		Main main = new Main();
		
		main.openSession();

		UserEntity user= new UserEntity();
		main.closeSession();
}





}// class