package com.furkan.soru2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Siparis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int siparisId;
	
	@ManyToOne
	private Musteri musteri;
	
	@OneToMany
	private List<SiparisKalemi> siparisKalemi;
	
	@Column(nullable = true)
	private int siparisToplam;
	
	
	public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemi) {
		super();
		this.musteri = musteri;
		this.siparisKalemi = siparisKalemi;
		this.siparisToplam=siparisKalemi.stream().mapToInt(a ->a.getKalemToplamı()).sum();
	}



	@Override
	public String toString() {
		return "Siparis [siparisId=" + siparisId + ", musteri=" + musteri.getMusteriAd()+", müsteri id"+musteri.getMusteriId() + "siparis toplam: "+this.siparisToplam+" kalem toplamı" +siparisKalemi.stream().mapToInt(o ->o.getKalemToplamı()).sum();
	}



	
	
	
	

}
