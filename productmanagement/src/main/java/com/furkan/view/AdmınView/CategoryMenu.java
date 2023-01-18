package com.furkan.view.AdmınView;

import java.util.Scanner;

import com.furkan.Main;
import com.furkan.controller.adminController.CategoryController;
import com.furkan.entity.Category;

public class CategoryMenu {
	static Scanner src = new Scanner(System.in);
	static CategoryController categoryController= new CategoryController();
	static AdminMainMenu adminMainMenu = new AdminMainMenu();
	
	public static void main(String[] args) {
	categoryMenu();
	
	}

	

	// category menu
	public static void categoryMenu() {
		System.out.println("-------------------------------------");
		System.out.println("***** Welcome to CATEGORY MENU ******");
		System.out.println("-------------------------------------");

		System.out.println("select operation:  ");
		System.out.println("1_Category Save\n2_Category update \n3_Category delete \n4_Category & Product List\n5_find category name \n6_Admin Menu");
		
		int choose= src.nextInt();
		Scanner src = new Scanner(System.in);

		switch (choose) {
		case 1: {
			saveCategory();
			categoryMenu();
		}case 2:{
			updateCategory();
			categoryMenu();
			
		}case 3:{
			deleteCategory();
			categoryMenu();

		}case 4: {
			findAll();
			categoryMenu();
			
		}case 5:{
			findByNameLıke();
			categoryMenu();
			
		}
		case 6:{
			adminMainMenu.main(null);
			
		}
		default:{
			throw new IllegalArgumentException("unkown choose: " + choose);
		}
		}
	}
	
	
	public static void saveCategory() {
		Scanner src = new Scanner(System.in);
		System.out.println("enter the category name ");
		String categoryName = src.nextLine();
		categoryController.saveCategory(categoryName);
	}

	
	public static void updateCategory() {
		Scanner src = new Scanner(System.in);
		System.out.println(" enter the category id");
		long id= src.nextLong();
		categoryController.update(id);
		
	}
	public static void deleteCategory() {
		System.out.println("****** calismiyor **** -> bu kategoriye ait bir ürün sepette ekli ise  ");
		Scanner src = new Scanner(System.in);
		System.out.println("enter the category id");
		long id = src.nextLong();
		categoryController.delete(id);
	}
	public static void findAll() {
		categoryController.findAll();
	}
	
	public static void findByNameLıke() {
		Scanner src = new Scanner(System.in);
		System.out.println("enter the category name ->findByNameLıke");
		String name = src.nextLine();
		categoryController.findByNameLike(name);
		
	}
	
	
}
