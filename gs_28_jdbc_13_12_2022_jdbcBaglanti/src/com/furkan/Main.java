package com.furkan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		System.out.println("baglanti kuruluyor");
		
		dbİslem(dbConnect());
//		
//		String adres= "jdbc:postgresql://localhost:5432/ders";
//		String kullaniciAdi="postgres";
//		String sifre= "asd123asd";
//		
//		Connection conn= null;
//		
//		try {
//			conn= DriverManager.getConnection(adres, kullaniciAdi, sifre);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("bağlanti hatasi");
//		}
//		
//		try {
//			conn.close();
//			
//		} catch (SQLException e) {
//			System.out.println("kapanirken hata");
//			e.printStackTrace();
//		}
//		
//		String musteriListSql= "select * from laptop where marka='msi'";
//		
//		PreparedStatement pr;
//		
//		try {
//			pr= conn.prepareCall(musteriListSql);
//			ResultSet res=pr.executeQuery();
//			
//			while(res.next()) {
//				System.out.println("musteri id : "+res.getInt(1)+", ad:"+res.getString(2));
//			}
//			
//			
//		} catch (SQLException e) {
//			System.out.println("sql komut hatasi");
//			e.printStackTrace();
//		}
//		
		
		
	}
	
	
	
	public static Connection dbConnect() {
		String url= "jdbc:postgresql://localhost:5432/ders";
		String id= "postgres";
		String password= "asd123asd";
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			System.out.println("baglanti hatasi");
			e.printStackTrace();
		}
		System.out.println("db acildi");
		return conn;
		
	}
	
	
		public static void dbDisconnect(Connection con) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Db kapanirkan hata");
				e.printStackTrace();
			}
			System.out.println("db kapandi");

		}
		
		
		public static void dbİslem(Connection con) {
			PreparedStatement prp;
			ResultSet rs = null;
			String findMusteri = "select * from musteri";
			
			try {
				prp=con.prepareCall("select * from musteri");
				
				rs= prp.executeQuery();
				while (rs.next()) {
					System.out.println("musteri id:"+rs.getInt(1));
				}
				
				
			} catch (SQLException e) {
				System.out.println("sorgu sirasinda hata...");
				e.printStackTrace();
			}
			
			
			
			String createMusteri="insert into laptop(id,marka,model) "
					+ "values (334,'hp','fullhd')";
			
			try {
				prp=con.prepareCall(createMusteri);
				prp.executeUpdate();
				System.out.println("kayit basarili");
			} catch (SQLException e) {
				System.out.println("yeni kayıtta hata");
				e.printStackTrace();
			}
		
			
			
			dbDisconnect(con);
			
		}
		
		
		
		

}
