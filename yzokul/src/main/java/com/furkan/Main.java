package com.furkan;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.furkan.entity.Student;

public class Main {

	public static void main(String[] args) {

		Student student= new Student("ali","koç","11.08.1998","a@gmail.com","1234");
		Main m= new Main();
		m.save(student);
		
	}
	
	
	
	public void save(Student t) {
		com.furkan.util.HibernateUtils a= new com.furkan.util.HibernateUtils();

		Transaction transaction = null;

		try (Session session = a.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();

			}
			System.out.println("Saved Error");
		}

	}

}
