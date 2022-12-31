package com.furkan.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.furkan.entity.Employee;
import com.furkan.util.DBConnection;

public class EmployeeRepository implements IEmployeeRepository {

	@Override
	public void insert(Employee emp) {
		
		
		Scanner sc= new Scanner (System.in);
	
		String sqlkomut = "insert into ogrenci (name, salary,age ) values( ?, ?, ?)";
		 
		PreparedStatement prp;
		try {
			prp = DBConnection.connection().prepareCall(sqlkomut);
			prp.setString(1, emp.getName());
			prp.setInt(2, emp.getSalary());
			prp.setInt(3,emp.getAge());
			
			
			prp.executeUpdate();   		//---> Query'i veritabanına gönder

			System.out.println("Kayıt ekleme işlemi başarılı");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Kayıt işlemi başarısızdır.");

		}
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
