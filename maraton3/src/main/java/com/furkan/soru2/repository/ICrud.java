package com.furkan.soru2.repository;

import java.util.List;

public interface ICrud<T> {
	public void openSession();
	public void closeSession();
	public void closeRollBack();
	public void save(T t);
	public void update(int id,T t);
	public void delete(int id);
	public List<T> findAll();
	public T findById(int id);


}
