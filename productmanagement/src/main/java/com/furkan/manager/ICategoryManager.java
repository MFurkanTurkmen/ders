package com.furkan.manager;

import java.util.List;

import com.furkan.entity.Category;

public interface ICategoryManager {
	public void save(Category category);
	public void update(long id, Category category);
	public void delete(Category category);
	public List<Category> findAll();
	public Category findById(long id);
	public List<Category> findByNameLıke(String Name);

}
