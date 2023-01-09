package com.furkan.soru2.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Urun {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int urunId;
	
	private String urunAd;
	private int fiyat;
	
	
	@Override
	public String toString() {
		return "Urun [urunAd=" + urunAd + ", fiyat=" + fiyat + "]";
	}
	public Urun(String urunAd, int fiyat) {
		super();
		this.urunAd = urunAd;
		this.fiyat = fiyat;
	}
	
	
	

	
	
}
