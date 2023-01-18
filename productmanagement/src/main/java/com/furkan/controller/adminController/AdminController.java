package com.furkan.controller.adminController;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

import com.furkan.entity.Admin;
import com.furkan.manager.Impl.AdminManager;

public class AdminController {
	
	static AdminManager adminManager= new AdminManager();
	

	
	public static void createAdmin() {
		Scanner src = new Scanner(System.in);
		System.out.print("name= ");
		String name = src.nextLine();
		System.out.print("last name= ");
		String lastName= src.nextLine();
		System.out.print("email= ");
		String email= src.nextLine();
		System.out.println("password");
		String password= src.nextLine();
		password= DigestUtils.sha256Hex(password);
		Admin admin = new Admin(name, lastName, email, password);
		adminManager.save(admin);
	}
	public static void updateAdmin() {
		Scanner src= new Scanner(System.in);
		System.out.println("enter the admin id");
		long id= src.nextLong();
		Admin admin = adminManager.findById(id);
		System.out.print("new admin name= ");
		String name = src.nextLine();
		admin.setName(null);
	}
	
	public static void deleteAdmin() {
		Scanner src= new Scanner(System.in);
		System.out.println("enter the admin id");
		long id = src.nextLong();
		Admin admin= adminManager.findById(id);
		adminManager.delete(admin);
	}
	
	public static void findAll() {
		for (Admin admin : adminManager.findAll()) {
			System.out.println(admin);
		}
	}
	
	public static void findByName() {
		Scanner src= new Scanner(System.in);
		System.out.println("enter admin name");
		String name= src.nextLine();
		for (Admin admin : adminManager.findByNameLıke(name)) {
			System.out.println(admin);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// class
