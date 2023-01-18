package com.furkan.manager.Impl;

import java.util.List;

import com.furkan.entity.Category;
import com.furkan.manager.ICategoryManager;
import com.furkan.repository.Impl.CategoryRepository;
import com.furkan.utilty.Singleton;

public class CategoryManager implements ICategoryManager {
	CategoryRepository categoryRepository= Singleton.getCategoryRepository();
	
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void update(long id, Category category) {
		categoryRepository.update(id, category);
		}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);		
	}

	@Override
	public List<Category> findAll() {
		return 	categoryRepository.findAll(Category.class);
	}

	@Override
	public Category findById(long id) {
		return 	categoryRepository.findById(Category.class, id)
;
	}

	@Override
	public List<Category> findByNameLıke(String name) {
		return categoryRepository.findByNameLike(Category.class, name);
	}

}
