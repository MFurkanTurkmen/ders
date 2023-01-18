package com.furkan.view.AdmınView;

import java.util.Scanner;

import com.furkan.controller.adminController.AdminController;
import com.furkan.controller.adminController.CategoryController;
import com.furkan.entity.Admin;
import com.furkan.repository.Impl.AdminRepository;
import com.furkan.view.MainMenu;

public class AdminMainMenu {
	
	static Scanner src= new Scanner(System.in);
	static CategoryController categoryController = new CategoryController();
	static CategoryMenu categoryMenu = new CategoryMenu();
	static ProductMenu productMenu = new ProductMenu();
	static CustomerMenu customerMenu = new CustomerMenu();
	static AdminController adminController= new AdminController();

	static AdminMainMenu adminMainMenu= new AdminMainMenu();
	
	public static void main(String[] args) {

		Scanner src = new Scanner(System.in);

		System.out.println("-------------------------------------");
		System.out.println("******* Welcome To Admın Menu *******");
		System.out.println("-------------------------------------");

		int tercih ;
		System.out.println("-> hangi menuye gitmek istersiniz: \n1_... Category Menu\n2_... Product Menu\n3_... Customer Menu\n"
				+ "4_... create admin \n5_... update admin \n6_... delete admin \n7_... admin list \n8_... find by admin name \n9_... main menu");

		tercih=src.nextInt();
		switch (tercih) {
		case 1: {
			categoryMenu.main(args);
		}case 2:{
			productMenu.main(args);
		}case 3:{
			customerMenu.main(args);
		}case 4:{
			createAdmin();
			adminMainMenu.main(args);
		}case 5:{
			updateAdmin();
			adminMainMenu.main(args);
		}case 6:{
			deleteAdmin();
			adminMainMenu.main(args);
		}case 7:{
			listAll();
			adminMainMenu.main(args);
		}case 8:{
			findByNameLıke();
			adminMainMenu.main(args);
		}case 9 :{
			myDelete((Admin)MainMenu.verify());
			
		}
			
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + tercih);
		}
		
		

	}
	
	public static void createAdmin() {
		Scanner src= new Scanner(System.in);
		adminController.createAdmin();
		
	}
	
	public static void updateAdmin() {
		adminController.updateAdmin();
	}
	
	public static void deleteAdmin() {
		adminController.deleteAdmin();
	}
	
	public static void listAll() {
		adminController.findAll();
	}
	public static void findByNameLıke() {
		adminController.findByName();
	}
	public static void myDelete(Admin admin) {
		AdminRepository adminRepository= new AdminRepository();
		adminRepository.delete(admin);
	}
	
	
	
	
	

}
