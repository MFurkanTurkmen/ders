package com.furkan.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.entity.Teacher;
import com.furkan.entity.Classroom;
import com.furkan.entity.Lessons;
import com.furkan.entity.Student;
import com.furkan.entity.Teacher;
import com.furkan.util.HibernateUtils;

public class TeacherDao implements ICrud<Teacher>{
	
	
	
	
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

	public void save(Teacher t) {
		try {
			openSession();
			System.out.println("asd");
			session.save(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- Teacher - Save de hata ---");
			closeRollBack();
		}

	}

	public void update(int id, Teacher t) {
		try {
			openSession();
			t.setTeacherId(id);
			session.merge(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- teacher - update de hata ---");
			closeRollBack();
		}

	}
	
	// ---- öğretmenin sadece dersini güncelleme
	public void update (int id, Lessons lesson) {
		try {
			openSession();
			Teacher teacher = session.get(Teacher.class, id);
			if(teacher!=null) {
				teacher.setLessons(lesson);
				session.merge(teacher);

			}
			closeSession();
		} catch (Exception e) {
			System.out.println("ders güncellemede hata");
		}
	}
	
	
	// ---- öğretmenin sadece classroomunu güncelleme
	public void update (int id, Classroom classroom) {
		List<Classroom> list = new ArrayList<Classroom>();
		try {
			openSession();
			Teacher teacher = session.get(Teacher.class, id);
			if(teacher!=null) {
				list= teacher.getClassroom();
				list.add(classroom);
				session.merge(teacher);

			}
			closeSession();
		} catch (Exception e) {
			System.out.println("ders güncellemede hata");
			closeRollBack();
		}
	}


	public void delete(int id) {
		Teacher teacher = null;
		try {
			openSession();
			teacher = session.find(Teacher.class, id);
			if (teacher != null) {
				System.out.println("buldu");
				
				session.delete(teacher);
				System.out.println("sildi");
			} else {
				System.out.println("id ile sınıf bulunamadı ve silinemedi");
			}
			closeSession();
		} catch (Exception e) {
			System.out.println("--- teacher - delete de hata ---");
			closeRollBack();
		}

	}

	public List<Teacher> findAll() {
		List<Teacher> teacher = null;
		try {
			String sorgu = "From Teacher";
			openSession();
			TypedQuery<Teacher> query = session.createQuery(sorgu,Teacher.class);
			if(query != null) {
				teacher =  query.getResultList();
			}else {
				System.out.println("teacher listesi bos");
			}
			closeSession();


		} catch (Exception e) {
			System.out.println("--- teacher - findall de hata ---");
			closeRollBack();

		}
		return teacher;
	}

	public Teacher findByName(String name) {
		Teacher teacher=null;
		
			openSession();
			String hql = "select user from Teacher as user where user.teacherName =:key ";
			Query query = session.createQuery(hql,Teacher.class);
			query.setParameter("key", name);
			try {	teacher=(Teacher) query.getSingleResult();
			closeSession();


		} catch (Exception e) {
			System.out.println("--- teacher - findbyname de hata ---");
			closeRollBack();

		}
		return teacher;
	}
	
	
	
	
	
	
	public Optional<Teacher> findByNameOptional(String teacherName) {
		openSession();
		Teacher teacher = null;
		String hql = "select user from Teacher as user where user.teacherName =:key ";
		Query query = session.createQuery(hql);
		query.setParameter("key", teacherName);
		try {
			teacher = (Teacher) query.getSingleResult();
			
			closeSession();
			return Optional.of(teacher);

		} catch (Exception e) {
			closeRollBack();
			return Optional.empty();
		}
	}

	public Teacher findById(int id) {
		Teacher teacher = null;
		try {
			openSession();
			teacher = session.find(Teacher.class, id);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- teacher - findbyid de hata ---");
			closeRollBack();

		}
		return teacher;
	}
	

}
