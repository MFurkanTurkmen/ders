package com.furkan.repository.myRepo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.furkan.util.HibernateUtils;

public interface MyICrud <T> {
	
	public void openSession();
	public void closeSession();
	public void closeRollBack();
	public void save (T t);
	public void update(T t, int id);
	public void delete(T t);
	public List<T> findAll(T t);
	public T findById(T t,int id);
	
	

}
