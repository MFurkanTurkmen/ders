package com.furkan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	
	public static Connection connection() {
		System.out.println("trying to connect...");
		String url = "jdbc:postgresql://localhost:5432/katmanli"; // localhost: 127.0.0.1 her bilgisayarda local IP olarak tanimlidar. WAN -> IP servis sag
		String kullaniciadi = "postgres";
		String sifre = "asd123asd";
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection (url, kullaniciadi, sifre);
		System.out.println("Connection established....");

		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		return conn;
		
		
	}
	
	
	
	

	
}
