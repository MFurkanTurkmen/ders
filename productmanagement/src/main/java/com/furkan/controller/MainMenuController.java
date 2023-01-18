package com.furkan.controller;

import java.util.Scanner;

import com.furkan.controller.adminController.AdminController;
import com.furkan.entity.Admin;
import com.furkan.manager.Impl.AdminManager;
import com.furkan.manager.Impl.CustomerManager;

public class MainMenuController {
	static AdminManager adminManager= new AdminManager();
	static CustomerManager customerManager = new CustomerManager();
	static AdminController adminController= new AdminController();
	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		System.out.println("--------------------");
		System.out.println("Welcome to Main Menu");
		System.out.println("--------------------");
		System.out.println("enter the mail address");
		String mail= src.nextLine();
		System.out.println("enter the password");
		String password= src.nextLine();
		
		
		for(Admin admin : adminManager.findAll() ) {
			if(admin.getEmail()==mail && admin.getPassword()==password) {
				adminController.
			}
			
		}
	}

}
