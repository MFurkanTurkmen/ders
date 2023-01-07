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
	public <T> List<T> findAll(Class<T> t);
	public T findById(Class<T> type,int id);
	
	

}
