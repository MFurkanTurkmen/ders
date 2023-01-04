package com.furkan.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.furkan.entity.Classroom;
import com.furkan.entity.Lessons;
import com.furkan.entity.Student;
import com.furkan.entity.Teacher;

public class HibernateUtils {

	
	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	
	private static SessionFactory sessionFactoryHibernate() {
		

			try {
			Configuration configuration = new Configuration();
			
		//üzerinde çalıştığımız classları gelip buraya ekliyoruz
			configuration.addAnnotatedClass(Lessons.class);
			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Teacher.class);
			configuration.addAnnotatedClass(Classroom.class);



			
			
			
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
