package com.furkan.view.CustomerView;

import java.util.Scanner;

public class CustomerMainMenu {

	public static void main(String[] args) {
		


		System.out.println("-------------------------------------");
		System.out.println("******* Welcome To Customer Menu *******");
		System.out.println("-------------------------------------");

		Scanner src= new Scanner(System.in);
		int tercih ;
		System.out.println("-> hangi menuye gitmek istersiniz: \n1_... create cart \n2_... add product to cart \n"
				+ "3_... delete product to my cart \n4_... buy cart \n5_... update my info  \n6_... product list \n7_... category list \n9_... main menu");

		tercih=src.nextInt();
		switch (tercih) {
		case 1: {
			
		}case 2:{
			
		}case 3:{
			
		}case 4:{
			
		}case 5:{
			
		}case 6:{
			
		}case 7:{
			
		}case 8:{
			
		}case 9 :{
			//main menu
		}
			
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + tercih);
		}
		
		public static void createCart(Customer customer) {
			categoryController.findAll();
		}
		
		public static void addProductToCart() {
			categoryController.findAll();
		}
		
		public static void deleteProductToCart() {
			categoryController.findAll();
		}
		public static void buyCart() {
			categoryController.findAll();
		}
		
		
		public static void findAllCategory() {
			categoryController.findAll();
		}
		public static void deleteProduct() {
			System.out.println("****** calismiyor ***********");
			Scanner src = new Scanner(System.in);
			System.out.println("delete -> enter the product id");
			long id = src.nextLong();
			productController.delete(id);
		}

		public static void findAllProduct() {
			productController.findAll();
		}

		public static void commentProduct() {
			productController.comment();
		}
		public static void findByNameLıkeProduct() {
			Scanner src = new Scanner(System.in);
			System.out.println("enter the product name ->find by name");
			String name = src.nextLine();
			productController.findByNameLike(name);
		}

	}
}
