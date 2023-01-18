package com.furkan.view.AdmınView;

import java.util.Scanner;

import com.furkan.controller.adminController.CustomerController;

public class CustomerMenu {
	
	static CustomerController customerController = new CustomerController(); 
	static AdminMainMenu adminMainMenu = new AdminMainMenu();

	public static void main(String[] args) {
		customerMenu();
	}
	
	public static void customerMenu() {
		Scanner src= new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.println("***** Welcome to Customer MENU *****");
		System.out.println("------------------------------------");

		System.out.println("select operation:  ");
		System.out.println("1_Customer List \n2_find by name for customer \n3_Admin Menu");
		
		int choose= src.nextInt();

		switch (choose) {
		case 1: {
			customerList();
			customerMenu();
		}case 2:{
			customerFindByNameLıke();
			customerMenu();
			
		}case 3: {
			adminMainMenu.main(null);

		}
		default:{
			throw new IllegalArgumentException("unkown choose: " + choose);
		}
		}
	}
	
	
	public static void customerList() {
		customerController.findAll();
	}
	public static void customerFindByNameLıke() {
		Scanner src = new Scanner(System.in);
		System.out.println("enter the customer name ->findByNameLıke");
		String name = src.nextLine();
		customerController.findByNameLike(name);
	}

}
