package com.guraysungur.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.guraysungur.entity.Okul;
import com.guraysungur.utils.HibernateUtil;

public class OkulDao {

	
	public List<Okul> getAll() {			
		Transaction transaction = null;
		List<Okul> list = null;								
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {			
			// start transaction
			transaction = session.beginTransaction();			
			//get Ogretmen objects
			list = session.createQuery("select okul from Okul okul").list();				
			// commit transaction
			transaction.commit();						
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}			
		}
		
		return list;
		
		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Query query = session.createQuery("select okul from Okul okul");  // => select * from okul
//		return query.list();						
	}
	
	
}
