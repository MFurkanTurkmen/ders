package com.furkan.controller.adminController;

import java.util.Scanner;

import com.furkan.entity.Category;
import com.furkan.entity.Product;
import com.furkan.entity.Sepet;
import com.furkan.manager.Impl.CategoryManager;
import com.furkan.manager.Impl.SepetManager;

public class CategoryController {
	
	CategoryManager categoryManager = new CategoryManager();
	SepetManager sepetManager = new SepetManager();
	Scanner src= new Scanner(System.in);
	
	public void saveCategory(String name) {
		Category category = new Category(name);
		categoryManager.save(category);
	}
	
	public void update (long id) {
		System.out.println("enter The new category name");
		String name = src.nextLine();
		Category category= categoryManager.findById(id);
		category.setName(name);
		categoryManager.update(id, category);
		
	}
	
	public void delete(long id) {
		Category category = categoryManager.findById(id);
		for (Product nt : category.getProduct()) {
			nt.setCategory(null);								// --- hatalı çalışmıyor-----
		}
		category.setProduct(null);
		categoryManager.delete(category);
	}
	
	public void findAll() {
		for (Category ct : categoryManager.findAll()) {
			System.out.println(ct);
		}
	}
	
	public void findByNameLike(String name) {
		for(Category ct : categoryManager.findByNameLıke(name)) {
			System.out.println(ct);
		}
	}

}
