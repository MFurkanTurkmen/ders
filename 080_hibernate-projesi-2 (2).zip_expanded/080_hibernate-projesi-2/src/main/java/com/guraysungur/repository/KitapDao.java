package com.guraysungur.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.guraysungur.entity.Kitap;
import com.guraysungur.utils.HibernateUtil;

public class KitapDao {

	public void save(Kitap kitap) throws Exception {
		Transaction transaction = null;		
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {			
			// start transaction
			transaction = session.beginTransaction();			
			// save object
			session.save(kitap);			
			// commit transaction
			transaction.commit();								
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("kayıt başarısız!");
		}
		
	}

}
