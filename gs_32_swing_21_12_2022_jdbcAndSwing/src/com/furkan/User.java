package com.furkan;

public class User {
	private int id;
	private String ad;
	private String soyad;
	
	
	public User(int id, String ad, String soyad) {
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", ad=" + ad + ", soyad=" + soyad + "]";
	}
	
	
	

}
