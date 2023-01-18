package com.furkan.repository;

import java.util.List;

import org.hibernate.Session;

import com.furkan.entity.Ogrenci;
import com.furkan.util.HibernateUtils;

public interface ICrud<T> {

public void create(T entity);
	
	public void delete(Ogrenci ogrenci);
	
	public void update(long id, T entity);
	
	public List<T> listAll();
	
	public T find(long id);
	
	default Session dataBaseConnectionHibernate() {

		return HibernateUtils.getSessionFactory().openSession();
	}
}
