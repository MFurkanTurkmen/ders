package com.furkan.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.entity.Classroom;
import com.furkan.util.HibernateUtils;

public class ClassroomDao implements ICrud<Classroom> {
	private Session session;
	private Transaction transaction;

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
	public void save(Classroom t) {
		try {
			openSession();
			session.save(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- Classroom - Save de hata ---");
			closeRollBack();
		}

	}

	@Override
	public void update(int id, Classroom t) {
		try {
			openSession();
			t.setClassroomId(id);
			session.merge(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- classroom - update de hata ---");
			closeRollBack();
		}

	}

	@Override
	public void delete(int id) {
		Classroom classroom = null;
		try {
			openSession();
			classroom = session.find(Classroom.class, id);
			if (classroom != null) {
				session.delete(classroom);
			} else {
				System.out.println("id ile sınıf bulunamadı ve silinemedi");
			}

		} catch (Exception e) {
			System.out.println("--- classroom - delete de hata ---");
			closeRollBack();

		}

	}

	@Override
	public List<Classroom> findAll() {
		List<Classroom> classroom = null;
		try {
			String sorgu = "From Classroom";
			openSession();
			TypedQuery<Classroom> query = session.createQuery(sorgu,Classroom.class);
			if(query != null) {
				classroom = query.getResultList();
			}else {
				System.out.println("ögrenci listesi bos");
			}
			

		} catch (Exception e) {
			System.out.println("--- classroom - findall de hata ---");
			closeRollBack();

		}
		return classroom;
	}

	@Override
	public Classroom findByName(String name) {
		Classroom classroom=null;
		try {
			openSession();
			String sorgu= "Select name From Classroom as Where classroom.className=:key";
			
			Query query = session.createQuery(sorgu,Classroom.class);
			query.setParameter("key", name);
			classroom=(Classroom) query.getSingleResult();
			

		} catch (Exception e) {
			System.out.println("--- classroom - findbyname de hata ---");
			closeRollBack();

		}
		return classroom;
	}

	@Override
	public Classroom findById(int id) {
		Classroom classroom = null;
		try {
			openSession();
			classroom = session.find(Classroom.class, id);

			if (classroom != null) {
				System.out.println("id ile sınıf bulundu : " + classroom);

			} else {
				System.out.println("kullanici bulunamadı");
			}
			closeSession();

		} catch (Exception e) {
			System.out.println("--- classroom - findbyid de hata ---");
			closeRollBack();

		}
		return classroom;
	}
	
	

}
