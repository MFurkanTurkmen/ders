package com.furkan.soru2.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.furkan.soru2.entity.Urun;
import util.HibernateUtils;

public class UrunRepository implements ICrud<Urun> {

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

	public void save(Urun t) {
		try {
			openSession();
			session.save(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- Urun - Save de hata ---");
			closeRollBack();
		}

	}

	public void update(int id, Urun t) {
		try {
			openSession();
			t.setUrunId(id);
			session.merge(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- urun - update de hata ---");
			closeRollBack();
		}

	}

	public void delete(int id) {
		Urun urun = null;
		try {
			openSession();
			urun = session.find(Urun.class, id);
			if (urun != null) {
				System.out.println("buldu");
				session.delete(urun);
				System.out.println("sildi");
			} else {
				System.out.println("id ile sınıf bulunamadı ve silinemedi");
			}
			closeSession();
		} catch (Exception e) {
			System.out.println("--- urun - delete de hata ---");
			closeRollBack();
		}

	}

	public List<Urun> findAll() {
		List<Urun> urun = null;
		try {
			String sorgu = "From Urun";
			openSession();
			TypedQuery<Urun> query = session.createQuery(sorgu,Urun.class);
			if(query != null) {
				urun =  query.getResultList();
			}else {
				System.out.println("urun listesi bos");
			}
			

		} catch (Exception e) {
			System.out.println("--- urun - findall de hata ---");
			closeRollBack();

		}
		return urun;
	}
	public Urun findById(int id) {
		Urun urun = null;
		try {
			openSession();
			urun = session.find(Urun.class, id);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- urun - findbyid de hata ---");
			closeRollBack();

		}
		return urun;
	}
	
	

}
