package com.furkan.repository.myRepo;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import com.furkan.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class MyCrud<T> implements MyICrud<T> {
	
	private Session session;
	private Transaction transaction;
	private CriteriaBuilder criteriaBuilder;
	private EntityManager entityManager;
	
	public MyCrud() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		criteriaBuilder = entityManager.getCriteriaBuilder();
	}

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

	@Override
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
	

	@Override
	public void delete(T t) {
		try {
			openSession();
			session.delete(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("repoda delete hatasi");
		}
		
	}

	@Override
	public List<T> findAll(T t) {
		List<T> list=null;
        openSession();
        Criteria cr=session.createCriteria(t.getClass());
        list=cr.list();
        closeSession();
        return list;
	}

	@Override
	public T findById(T t, int id) {
		T result=null;
        openSession();
        Criteria cr =session.createCriteria(t.getClass());
        cr.add(Restrictions.eq("id",id));
        if(cr.list().size()>0){
            result=(T) cr.list().get(0);
        }
        else {
            System.out.println("yanlis");
        }
        return result;
	}


	


	

//	
	
}
