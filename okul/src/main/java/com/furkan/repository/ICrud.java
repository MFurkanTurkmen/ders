package com.furkan.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {

	public void openSession();
	public void closeSession();
	public void closeRollBack();
	public void save(T t);
	public void update(int id,T t);
	public void delete(int id);
	public List<T> findAll();
	public T findByName(String name);
	public Optional<T> findByNameOptional(String name);
	public T findById(int id);
	
}
