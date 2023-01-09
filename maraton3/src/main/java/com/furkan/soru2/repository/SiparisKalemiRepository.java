package com.furkan.soru2.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.furkan.soru2.entity.SiparisKalemi;
import util.HibernateUtils;

public class SiparisKalemiRepository implements ICrud<SiparisKalemi> {
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

	public void save(SiparisKalemi t) {
		try {
			openSession();
			session.save(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- SiparisKalemi - Save de hata ---");
			closeRollBack();
		}

	}

	public void update(int id, SiparisKalemi t) {
		try {
			openSession();
			t.setSiparisKalemiId(id);
			session.merge(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- siparisKalemi - update de hata ---");
			closeRollBack();
		}

	}

	public void delete(int id) {
		SiparisKalemi siparisKalemi = null;
		try {
			openSession();
			siparisKalemi = session.find(SiparisKalemi.class, id);
			if (siparisKalemi != null) {
				System.out.println("buldu");
				session.delete(siparisKalemi);
				System.out.println("sildi");
			} else {
				System.out.println("id ile sınıf bulunamadı ve silinemedi");
			}
			closeSession();
		} catch (Exception e) {
			System.out.println("--- siparisKalemi - delete de hata ---");
			closeRollBack();
		}

	}

	public List<SiparisKalemi> findAll() {
		List<SiparisKalemi> siparisKalemi = null;
		try {
			String sorgu = "From SiparisKalemi";
			openSession();
			TypedQuery<SiparisKalemi> query = session.createQuery(sorgu,SiparisKalemi.class);
			if(query != null) {
				siparisKalemi =  query.getResultList();
			}else {
				System.out.println("siparisKalemi listesi bos");
			}
			

		} catch (Exception e) {
			System.out.println("--- siparisKalemi - findall de hata ---");
			closeRollBack();

		}
		return siparisKalemi;
	}
	public SiparisKalemi findById(int id) {
		SiparisKalemi siparisKalemi = null;
		try {
			openSession();
			siparisKalemi = session.find(SiparisKalemi.class, id);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- siparisKalemi - findbyid de hata ---");
			closeRollBack();

		}
		return siparisKalemi;
	}
	

}
