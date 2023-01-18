package com.furkan.repository;

import java.util.List;

public interface ICrud<T> {
	public void openSession();
	public void closeSession();
	public void closeRollBack();
	public void save (T t);
	public void update(long id ,T t );
	public void delete(T t);
	public <T> List<T> findAll(Class<T> t);
	public T findById(Class<T> type,long id);
	public <T> List<T> findByNameLike(Class<T> type,String name);	
	

}
