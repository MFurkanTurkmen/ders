package com.furkan.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkan.entity.Attendance;
import com.furkan.entity.Classroom;
import com.furkan.entity.Course;
import com.furkan.entity.Enrollment;
import com.furkan.entity.Grade;
import com.furkan.entity.Student;
import com.furkan.entity.Teacher;



public class HibernateUtils {

	
	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	
	private static SessionFactory sessionFactoryHibernate() {
		

			try {
			Configuration configuration = new Configuration();
			
		//üzerinde çalıştığımız classları gelip buraya ekliyoruz
			configuration.addAnnotatedClass(Attendance.class);
			configuration.addAnnotatedClass(Classroom.class);
			configuration.addAnnotatedClass(Course.class);
			configuration.addAnnotatedClass(Enrollment.class);
			configuration.addAnnotatedClass(Grade.class);
			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Teacher.class);


			
			
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
			
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}	
		
		return null;
	}


	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	
			

}
