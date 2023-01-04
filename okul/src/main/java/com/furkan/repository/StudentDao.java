package com.furkan.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.entity.Student;
import com.furkan.util.HibernateUtils;

public class StudentDao implements ICrud<Student> {
	Session session = null;
	Transaction transaction;

	@Override
	public void openSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	@Override
	public void closeSession() {
		transaction.commit();
		session.close();

	}

	@Override
	public void closeRollBack() {
		transaction.rollback();
		session.close();

	}

	@Override
	public void save(Student t) {

		try {
			openSession();
			session.persist(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- student - save hatasi---");
			closeRollBack();
		}

	}

	@Override
	public void update(int id, Student t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
