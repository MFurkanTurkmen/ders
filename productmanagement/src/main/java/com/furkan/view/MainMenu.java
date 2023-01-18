package com.furkan.view;

import java.util.Scanner;

import com.furkan.controller.adminController.AdminController;
import com.furkan.entity.Admin;
import com.furkan.entity.Customer;
import com.furkan.manager.Impl.AdminManager;
import com.furkan.manager.Impl.CustomerManager;
import com.furkan.view.AdmınView.AdminMainMenu;
import com.furkan.view.AdmınView.CustomerMenu;
import com.furkan.view.CustomerView.CustomerMainMenu;

public class MainMenu {

	static AdminManager adminManager = new AdminManager();
	static CustomerManager customerManager = new CustomerManager();
	static AdminMainMenu adminMainMenu = new AdminMainMenu();
	static CustomerMainMenu customerMainMenu = new CustomerMainMenu();

	public static void main(String[] args) {		Scanner src = new Scanner(System.in);

		System.out.println("--------------------");
		System.out.println("Welcome to Main Menu");
		System.out.println("--------------------");
		verify();

	}

	public static Object verify() {
		Scanner src = new Scanner(System.in);
		
		System.out.println("enter the mail address");
		String mail = src.nextLine();
		System.out.println("enter the password");
		String password = src.nextLine();
		for (String admin : adminManager.findAll().stream().map(obj -> obj.getEmail()+obj.getPassword()).toList()) {
			System.out.println("girdi1");
			if (admin.contains(mail) && admin.contains(password)  ) {
				System.out.println("girdi");
				adminMainMenu.main(null);
				return admin;
			}
		}
		for (String customer : customerManager.findAll().stream().map(obj -> obj.getEmail()+obj.getPassword()).toList()) {
			if (customer.contains(mail)) {
				System.out.println("girdi");
				customerMainMenu.main(null);
				return customer;  }
		}
		return null;
	
	}

}
