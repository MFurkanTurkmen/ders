package com.furkan.controller;

import com.furkan.entity.Category;
import com.furkan.service.CategoryService;
import com.furkan.utils.BAUtils;

public class CategoryController {
	
	CategoryService categoryService;
	
	public CategoryController() {
		categoryService = new CategoryService();
	}
	

	public void create() {
		String name = BAUtils.readString("Please enter category name: ");
		
		Category category = new Category(name);
		
		categoryService.create(category);
		
	}

}
