package com.furkan.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.entity.Lessons;
import com.furkan.entity.Lessons;
import com.furkan.entity.Student;
import com.furkan.entity.Teacher;
import com.furkan.util.HibernateUtils;

public class LessonsDao implements ICrud<Lessons> {

	private Session session;
	private Transaction transaction;

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

	public void save(Lessons t) {
		try {
			openSession();
			session.save(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- Lessons - Save de hata ---");
			closeRollBack();
		}

	}

	public void update(int id, Lessons t) {
		try {
			openSession();
			t.setLessonsId(id);
			session.merge(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- Lessons - update de hata ---");
			closeRollBack();
		}

	}

	public void delete(int id) {
		Lessons lessons = null;
		try {
			openSession();
			lessons = session.find(Lessons.class, id);
			if (lessons != null) {
				System.out.println("buldu");
				for (Teacher teacher : lessons.getTeacher()) {
					teacher.setLessons(null);
				}
				session.delete(lessons);
				System.out.println("sildi");
			} else {
				System.out.println("id ile sınıf bulunamadı ve silinemedi");
			}
			closeSession();
		} catch (Exception e) {
			System.out.println("--- Lessons - delete de hata ---");
			closeRollBack();
		}

	}

	public List<Lessons> findAll() {
		List<Lessons> Lessons = null;
		try {
			String sorgu = "From Lessons";
			openSession();
			TypedQuery<Lessons> query = session.createQuery(sorgu,Lessons.class);
			if(query != null) {
				Lessons =  query.getResultList();
			}else {
				System.out.println("ögrenci listesi bos");
			}
			
			closeSession();

		} catch (Exception e) {
			System.out.println("--- Lessons - findall de hata ---");
			closeRollBack();

		}
		return Lessons;
	}

	public Lessons findByName(String name) {
		Lessons Lessons=null;
		
			openSession();
			String hql = "select user from Lessons as user where user.lessonName =:key ";
			Query query = session.createQuery(hql,Lessons.class);
			query.setParameter("key", name);
			try {	
				Lessons=(Lessons) query.getSingleResult();
			closeSession();
			

		} catch (Exception e) {
			System.out.println("--- Lessons - findbyname de hata ---");
			closeRollBack();

		}
		return Lessons;
	}
	
	
	
	
	
	
	public Optional<Lessons> findByNameOptional(String classname) {
		openSession();
		Lessons Lessons = null;
		String hql = "select user from Lessons as user where user.className =:key ";
		Query query = session.createQuery(hql);
		query.setParameter("key", classname);
		try {
			Lessons = (Lessons) query.getSingleResult();
			closeSession();
			return Optional.of(Lessons);
			
		} catch (Exception e) {
			closeRollBack();
			return Optional.empty();
		}
	}

	public Lessons findById(int id) {
		Lessons Lessons = null;
		try {
			openSession();
			Lessons = session.find(Lessons.class, id);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- Lessons - findbyid de hata ---");
			closeRollBack();

		}
		return Lessons;
	}
	

}
