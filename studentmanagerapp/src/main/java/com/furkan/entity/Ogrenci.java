package com.furkan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ogrenci {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true,nullable = false)
	private String email;
	
	private String ad;
	
	private String soyad;
	
	@OneToOne(cascade = CascadeType.ALL)
	private OgrenciBilgi ogrenciBilgileri;
	
	private byte[] image;

	
	
	public Ogrenci(String email, String ad, String soyad, OgrenciBilgi ogrenciBilgileri, byte[] image) {
		super();
		this.email = email;
		this.ad = ad;
		this.soyad = soyad;
		this.ogrenciBilgileri = ogrenciBilgileri;
		this.image = image;
	}

	public Ogrenci(String email, String ad, String soyad) {
		super();
		this.email = email;
		this.ad = ad;
		this.soyad = soyad;
	}

	public Ogrenci(String email, String ad, String soyad, OgrenciBilgi ogrenciBilgileri) {
		super();
		this.email = email;
		this.ad = ad;
		this.soyad = soyad;
		this.ogrenciBilgileri = ogrenciBilgileri;
	}

	public Ogrenci() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public OgrenciBilgi getOgrenciBilgileri() {
		return ogrenciBilgileri;
	}

	public void setOgrenciBilgileri(OgrenciBilgi ogrenciBilgileri) {
		this.ogrenciBilgileri = ogrenciBilgileri;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	

	
	
	
	
}
