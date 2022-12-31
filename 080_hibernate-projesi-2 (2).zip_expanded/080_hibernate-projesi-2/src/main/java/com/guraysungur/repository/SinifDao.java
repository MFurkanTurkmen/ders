package com.guraysungur.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.guraysungur.entity.Okul;
import com.guraysungur.entity.Sinif;
import com.guraysungur.utils.HibernateUtil;

public class SinifDao {

	public void save(Sinif sinif) throws Exception {
		Transaction transaction = null;		
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {			
			// start transaction
			transaction = session.beginTransaction();			
			// save object
			session.save(sinif);			
			// commit transaction
			transaction.commit();					
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("kayıt başarısız!");
		}
		
	}

	public List<Sinif> getAll() {
		Transaction transaction = null;
		List<Sinif> list = null;								
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {			
			// start transaction
			transaction = session.beginTransaction();			
			//get Ogretmen objects
			list = session.createQuery("select sinif from Sinif sinif").list();				
			// commit transaction
			transaction.commit();						
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}			
		}
		
		return list;
	}

}
