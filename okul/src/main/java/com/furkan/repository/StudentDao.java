package com.furkan.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.entity.Classroom;
import com.furkan.entity.Student;
import com.furkan.util.HibernateUtils;

public class StudentDao implements ICrud<Student> {
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

	
	public void save(Student t) {

		try {
			openSession();
			session.save(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- student - save hatasi---");
			closeRollBack();
		}

	}

	
	// ---- öğrenciyi genel nesne oluşturarak güncellem---- genel bir güncelleme yapar her şeyi yeniden belirtmemiz gerekir.
	
	public void update(int id, Student t) {
		try {
			openSession();
			t.setStudentNumber(id);
			session.merge(t);
			closeSession();
			
		} catch (Exception e) {
			closeRollBack();
		}

	}
	// --- öğrencinin sadece ad ve soyadını güncelleme----
	public void update(String name,String surname,int id) {
		try {
			openSession();
			Student student = session.get(Student.class, id);
			if (student != null) {
			  student.setStudentName(name);
			  student.setStudentSurname(name);
			  session.update(student);
			
			}
			closeSession();
			
		} catch (Exception e) {
			closeRollBack();
		}

	}
	// ---- öğrencinin sadece sınıfını güncelleme -----
	public void update(Classroom classroom,int id) {
		try {
			openSession();
			Student student = session.get(Student.class, id);
			if (student != null) {
			student.setClassroom(classroom);
			  session.update(student);

			}
			closeSession();
			
		} catch (Exception e) {
			closeRollBack();
		}

	}

	  		
	public void delete(int id) {
		Student student = null;
		try {
			openSession();
			student = session.find(Student.class, id);
			if (student != null) {
				System.out.println("buldu");
				session.delete(student);
				System.out.println("sildi");
			} else {
				System.out.println("id ile ogrenci bulunamadı ve silinemedi");
			}
			closeSession();

		} catch (Exception e) {
			System.out.println("--- student - delete de hata ---");
			closeRollBack();
		}

	}
	
	
	// ------ delete başka bir yol------ s
//	public void delete(int id) {
//		try {	
//			openSession();
//			Student student = session.get(Student.class,id);
//		if (student != null) {
//			  session.delete(student);
//			}
//		closeSession();
//			
//		} catch (Exception e) {
//			closeRollBack();
//		}
//	
//
//	}
	
	
	
	
	
	public List<Student> findAll() {
		List<Student> list= null;
		try {
			openSession();
			String hql= "from Student";
			TypedQuery<Student> tyQuery = session.createQuery(hql, Student.class);
			list =tyQuery.getResultList();
			closeSession();
			
		} catch (Exception e) {
			System.out.println("findall student hata !!!");
			closeRollBack();
		}
		return list;
	}

	
	public Student findByName(String name) {
		Student classroom=null;
		
		openSession();
		String hql = "select user from Student as user where user.studentName =:key ";
		Query query = session.createQuery(hql,Student.class);
		query.setParameter("key", name);
		try {	classroom=(Student) query.getSingleResult();
		

	} catch (Exception e) {
		System.out.println("--- Student - findbyname de hata ---");
		closeRollBack();

	}
	return classroom;
	}

	
	public Student findById(int id) {
		Student student =null;
		try {
			openSession();
			student =session.find(Student.class, id);
		} catch (Exception e) {
			System.out.println("student-find by id de hata");
		}
		return student;
	}

	
	public Optional<Student> findByNameOptional(String name) {
		openSession();
		Student student = null;
		String hql = "select user from Student as user where user.studentName =:key ";
		Query query = session.createQuery(hql);
		query.setParameter("key", name);
		try {
			student = (Student) query.getSingleResult();
			closeSession();
			return Optional.of(student);
		} catch (Exception e) {
			closeRollBack();
			return Optional.empty();
		}
	}
	
	



}
