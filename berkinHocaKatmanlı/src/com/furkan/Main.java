package com.furkan;

import java.util.Scanner;

import com.furkan.entity.Employee;
import com.furkan.repository.EmployeeRepository;
import com.furkan.repository.IEmployeeRepository;

public class Main {

	public static void main(String[] args) {
		

		IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
		
		
		Scanner scanner = new Scanner (System. in);
		
		do {
			
			System.out.println("1. Create Employee \n" + "2. Bütün Calisanlara Göster\n" + "3. Id ye göre Calisan Getir"
					+ "4. Calasana Güncelle \n" + "5. Calasana silln" + "6. (akas\n");
			System.out.println("Choose a number");
		
		int value = scanner. nextInt();
		switch (value) {
		
		
		case 1:{
			System.out.println("ad giriniz: ");
			String name = scanner.nextLine();
			System.out.println("ücret giriniz: ");
			int salary = scanner.nextInt();
			System.out.println("yas giriniz : ");
			int age = scanner.nextInt();
			Employee emp= new Employee(name, age, salary);
			iEmployeeRepository.insert(emp);
			
		}
			
			
		break;
		
		
		case 2:
			break;
		
		default:
			
			
		break;
		
		}

		
		
		}  while(true);
	
		
	}

}
