package com.furkan.soru2.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.soru2.entity.Siparis;
import com.furkan.soru2.entity.Siparis;

import util.HibernateUtils;

public class SiparisRepository implements ICrud<Siparis>{
	
	
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

	public void save(Siparis t) {
		try {
			openSession();
			session.save(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- Siparis - Save de hata ---");
			closeRollBack();
		}

	}

	public void update(int id, Siparis t) {
		try {
			openSession();
			t.setSiparisId(id);
			session.update(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- siparis - update de hata ---");
			closeRollBack();
		}

	}

	public void delete(int id) {
		Siparis siparis = null;
		try {
			openSession();
			siparis = session.find(Siparis.class, id);
			if (siparis != null) {
				System.out.println("buldu");
				session.delete(siparis);
				System.out.println("sildi");
			} else {
				System.out.println("id ile sınıf bulunamadı ve silinemedi");
			}
			closeSession();
		} catch (Exception e) {
			System.out.println("--- siparis - delete de hata ---");
			closeRollBack();
		}

	}

	public List<Siparis> findAll() {
		List<Siparis> siparis = null;
		try {
			String sorgu = "From Siparis";
			openSession();
			TypedQuery<Siparis> query = session.createQuery(sorgu,Siparis.class);
			if(query != null) {
				siparis =  query.getResultList();
			}else {
				System.out.println("siparis listesi bos");
			}
			

		} catch (Exception e) {
			System.out.println("--- siparis - findall de hata ---");
			closeRollBack();

		}
		return siparis;
	}
	public Siparis findById(int id) {
		Siparis siparis = null;
		try {
			openSession();
			siparis = session.find(Siparis.class, id);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- siparis - findbyid de hata ---");
			closeRollBack();

		}
		return siparis;
	}
	

}
