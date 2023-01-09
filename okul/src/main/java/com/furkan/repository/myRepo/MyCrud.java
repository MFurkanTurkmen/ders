package com.furkan.repository.myRepo;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaQuery;

import com.furkan.entity.Classroom;
import com.furkan.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class MyCrud<T> implements MyICrud<T> {
	
	private  Class T = null;
	private Session session;
	private Transaction transaction;
	private CriteriaBuilder criteriaBuilder;
	private EntityManager entityManager;
	public MyCrud() {
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

	
	public void update(T t, int id) {
		try {
			openSession();
			session.update(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("repo da update hatasi");
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
	
	
	
	public T findById(Class<T> type ,int id) {
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



	


	
}
