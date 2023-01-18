package com.furkan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.utilty.HibernateUtils;


public class Crud<T> implements ICrud<T> {
	private Session session;
	private Transaction transaction;
	private CriteriaBuilder criteriaBuilder;
	private EntityManager entityManager;
	
	public Crud() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		criteriaBuilder = entityManager.getCriteriaBuilder();
	}

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

	
	public void save(T t) {
		try {
			openSession();
			session.save(t);
			closeSession();
			
		} catch (Exception e) {
			System.out.println("repo da save hatasi");
			closeRollBack();
		}
		
	}

	
// bu update ile main de update ederken yeni nesne oluşturmalıyız.
	public void update(long id,T t ) {
		try {
			openSession();
			session.update(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- repo - update de hata ---");
			closeRollBack();
		}

	}	
	

	
	public void delete(T t) {
		try {
			openSession();
			session.delete(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("repoda delete hatasi");
			closeSession();
		}
		
	}
	
	
	
	public T findById(Class<T> type ,long id) {
		T entity= null;
		try {
			openSession();
			entity=session.find(type, id);
			closeSession();
		} catch (Exception e) {
			System.out.println("find by id hatasi");
			closeRollBack();
		}
		
		return entity;
	}


	


	public <T> List<T> findAll(Class<T> type) {
		  openSession();
		  String hql = "FROM " + type.getName();
		  TypedQuery<T> query = session.createQuery(hql);
		  List<T> list = query.getResultList();
		  session.close();
		  return list;
		}
	
	
	public <T> List <T> findByNameLike(Class<T> type,String name){
		List <T> listByName = null;
		String hql = "FROM " +type.getName()+" as c Where c.name LIKE :key";
		try {
			openSession();
			TypedQuery<T> typeQuery=session.createQuery(hql);
			typeQuery.setParameter("key", "%"+name+"%");
			listByName = typeQuery.getResultList();
			closeSession();
		} catch (Exception e) {
			System.out.println("find by name de hata");
			closeRollBack();
		}
		
		return listByName;
	}

	



	

}
