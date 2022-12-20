package com.furkan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System. in);
		String username = "";
		String password = "";
		do {
		System.out.print("Enter username: ");
		username = sc.nextLine ();
		System.out.print("Enter password: ");
		password = sc.nextLine();
		} while (!verifyUsernamePassword(username, password));
		System.out.println( "Sisteme hosgeldiniz...");
	}

	
	
	public static boolean verifyUsernamePassword(String username, String password) {
		
		boolean usernamepasswordCiftiMevcutMu = false;
		System.out.println("trying to connect...");
		String url = "jdbc:postgresql://localhost:5432/dbtest"; // localhost: 127.0.0.1 her bilgisayarda local IP olarak tanimlidar. WAN -> IP servis sag
		String kullaniciadi = "postgres";
		String sifre = "robot9";
		Connection conn = null;
		try {
		conn = DriverManager.getConnection (url, kullaniciadi, sifre);
		System.out.println("Connection established....");
		
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		
		// Select and Control
		String sqlkomut = "select username, password from users where username = '" + username + " and password = '" + password + "*";
		PreparedStatement prp;
		String uname, pass;
		try {
		prp = conn.prepareCall (sqlkomut);
		ResultSet rs = prp.executeQuery ();
		if (rs.next ( ))
		{
			usernamepasswordCiftiMevcutMu = true;
		}
		else
		{
			usernamepasswordCiftiMevcutMu = false;
		}
		} catch (SQLException e) { e.printStackTrace();
		}
		return usernamepasswordCiftiMevcutMu;
	
}
	
	
}
		
	
