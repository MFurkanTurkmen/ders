package com.furkan.soru2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkan.soru2.entity.Musteri;

import util.HibernateUtils;


public class MusteriRepository implements ICrud<Musteri> {

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

	public void save(Musteri t) {
		try {
			openSession();
			session.save(t);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- Musteri - Save de hata ---");
			closeRollBack();
		}

	}

	public void update(int id, Musteri t) {
		try {
			openSession();
			t.setMusteriId(id);
			session.merge(t);
			closeSession();

		} catch (Exception e) {
			System.out.println("--- musteri - update de hata ---");
			closeRollBack();
		}

	}

	public void delete(int id) {
		Musteri musteri = null;
		try {
			openSession();
			musteri = session.find(Musteri.class, id);
			if (musteri != null) {
				System.out.println("buldu");
				session.delete(musteri);
				System.out.println("sildi");
			} else {
				System.out.println("id ile sınıf bulunamadı ve silinemedi");
			}
			closeSession();
		} catch (Exception e) {
			System.out.println("--- musteri - delete de hata ---");
			closeRollBack();
		}

	}

	public List<Musteri> findAll() {
		List<Musteri> musteri = null;
		try {
			String sorgu = "From Musteri";
			openSession();
			TypedQuery<Musteri> query = session.createQuery(sorgu,Musteri.class);
			if(query != null) {
				musteri =  query.getResultList();
			}else {
				System.out.println("musteri listesi bos");
			}
			

		} catch (Exception e) {
			System.out.println("--- musteri - findall de hata ---");
			closeRollBack();

		}
		return musteri;
	}
	public Musteri findById(int id) {
		Musteri musteri = null;
		try {
			openSession();
			musteri = session.find(Musteri.class, id);
			closeSession();
		} catch (Exception e) {
			System.out.println("--- musteri - findbyid de hata ---");
			closeRollBack();

		}
		return musteri;
	}
	
	

	public void musteriSiparisleri() {
        Session session = null;
        EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
        List<Object[]> list = entityManager
                .createNativeQuery("select musteri_musteriid,count(*) from siparis group by musteri_musteriid").getResultList();

        for (Object[] element : list) {
            System.out.println("Müşteri ID: " + element[0] + " Sipariş Sayısı:" + element[1]);
        }
    }

    public void musteriSiparisId() {
        Session session = null;
        EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
        List<Object[]> list = entityManager
                .createNativeQuery("select musteri.musteriad , musteri.musterisoyad, siparis.siparisid from musteri \r\n"
                        + "inner join siparis on musteri.musteriid= siparis.musteri_musteriid ").getResultList();

        for (Object[] element : list) {
            System.out.println("Müşteri Ad: " + element[0] + " ,Müşteri Soyad:" + element[1]+ " ,Sipariş Id:"+ element[2]);
        }
    }

}
