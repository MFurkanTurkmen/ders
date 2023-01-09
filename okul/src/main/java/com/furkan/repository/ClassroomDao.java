package com.furkan.repository;

import java.util.*;

import javax.persistence.TypedQuery;

import org.hibernate.*;

import com.furkan.entity.Classroom;
import com.furkan.entity.Student;
import com.furkan.util.HibernateUtils;

public class ClassroomDao implements ICrud<Classroom> {
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

	public void delete(int id) {
		Classroom classroom = null;
		try {
			openSession();
			classroom = session.find(Classroom.class, id);
			if (classroom != null) {
				System.out.println("buldu");
				for (Student st : classroom.getStudent()) {
					st.setClassroom(null);
				}
				session.delete(classroom);
				System.out.println("sildi");
			} else {
				System.out.println("id ile sınıf bulunamadı ve silinemedi");
			}
			closeSession();
		} catch (Exception e) {
			System.out.println("--- classroom - delete de hata ---");
			closeRollBack();
		}

	}

	public List<Classroom> findAll() {
		List<Classroom> classroom = null;
		try {
			String sorgu = "From Classroom";
			openSession();
			TypedQuery<Classroom> query = session.createQuery(sorgu,Classroom.class);
			if(query != null) {
				classroom =  query.getResultList();
			}else {
				System.out.println("ögrenci listesi bos");
			}
			

		} catch (Exception e) {
			System.out.println("--- classroom - findall de hata ---");
			closeRollBack();

		}
		return classroom;
	}

	public Classroom findByName(String name) {
		Classroom classroom=null;
		
			openSession();
			String hql = "select user from Classroom as user where user.className =:key ";
			Query query = session.createQuery(hql,Classroom.class);
			query.setParameter("key", name);
			try {	classroom=(Classroom) query.getSingleResult();
			

		} catch (Exception e) {
			System.out.println("--- classroom - findbyname de hata ---");
			closeRollBack();

		}
		return classroom;
	}
	
	
	
	
	
	
	public Optional<Classroom> findByNameOptional(String classname) {
		openSession();
		Classroom classroom = null;
		String hql = "select user from Classroom as user where user.className =:key ";
		Query query = session.createQuery(hql);
		query.setParameter("key", classname);
		try {
			classroom = (Classroom) query.getSingleResult();
			closeSession();
			return Optional.of(classroom);
		} catch (Exception e) {
			closeRollBack();
			return Optional.empty();
		}
	}

	public Classroom findById(int id) {
		Classroom classroom = null;
		try {
			openSession();
			classroom = session.find(Classroom.class, id);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- classroom - findbyid de hata ---");
			closeRollBack();

		}
		return classroom;
	}
	
	
	public void deleteClass222(int id) {
		Classroom cl=null;
		
		try {
			openSession();
			 cl = session.find(Classroom.class, id);
			 
			for (Student st : cl.getStudent()) {
				st.setClassroom(null);
				}
			
				session.delete(cl);
				closeSession();
			
		} catch (Exception e) {
			System.out.println("hata");
			
			closeRollBack();
		}
		
			
	
	}
}

