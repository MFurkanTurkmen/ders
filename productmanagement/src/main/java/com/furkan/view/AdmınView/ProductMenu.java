package com.furkan.view.AdmınView;

import java.util.Scanner;

import com.furkan.controller.adminController.ProductController;

public class ProductMenu {
	static Scanner src = new Scanner(System.in);
	static AdminMainMenu adminMainMenu = new AdminMainMenu();
	static ProductController productController = new ProductController();

	public static void main(String[] args) {
		productMenu();

	}
	
	

	public static void productMenu() {
		System.out.println("-------------------------------------");
		System.out.println("****** Welcome to Product MENU ******");
		System.out.println("-------------------------------------");
	
		System.out.println("select operation:  ");
		System.out.println("1_Product Save\n"
				+ "2_Product update \n"
				+ "3_Product delete \n"
				+ "4_Product & Product List \n"
				+ "5_find comment for product\n"
				+ "6_find by product name\n"
				+ "7_admin menu");

		int choose = src.nextInt();
		Scanner src = new Scanner(System.in);

		switch (choose) {
		case 1: {
			saveProduct();
			productMenu();
		}
		case 2: {
			updateProduct();
			productMenu();

		}
		case 3: {
			deleteProduct();
			productMenu();

		}
		case 4: {
			findAll();
			productMenu();

		}
		case 5: {
			comment();
			productMenu();

		}
		case 6: {
			findByNameLıke();
			productMenu();

		}case 7:{			
			adminMainMenu.main(null);
			}
		
		default: {
			throw new IllegalArgumentException("unkown choose: " + choose);
		}
		}

	}

	public static void saveProduct() {
		productController.saveProduct();
	}

	public static void updateProduct() {
		Scanner src = new Scanner(System.in);
		System.out.println("update -> enter the product id");
		long id = src.nextLong();
		productController.update(id);

	}

	public static void deleteProduct() {
		System.out.println("****** calismiyor ***********");
		Scanner src = new Scanner(System.in);
		System.out.println("delete -> enter the product id");
		long id = src.nextLong();
		productController.delete(id);
	}

	public static void findAll() {
		productController.findAll();
	}

	public static void comment() {
		productController.comment();
	}
	public static void findByNameLıke() {
		Scanner src = new Scanner(System.in);
		System.out.println("enter the product name ->find by name");
		String name = src.nextLine();
		productController.findByNameLike(name);
	}

}
