package com.furkan.soru2.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Musteri {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int musteriId;
	
	private String musteriAd;
	private String musteriSoyad;
	
	@OneToMany(mappedBy = "musteri")
	private List<Siparis> siparis;

	
	
	public Musteri(String musteriAd, String musteriSoyad) {
		super();
		this.musteriAd = musteriAd;
		this.musteriSoyad = musteriSoyad;
	}
	
	

	@Override
	public String toString() {
		return "musteriId=" + musteriId + ", musteriAd=" + musteriAd + ", musteriSoyad=" + musteriSoyad +", siparisler "+siparis.stream().map(obj ->"toplam fiyat"+ obj.getSiparisToplam()+", detay:"+obj.getSiparisKalemi().stream().map(ob->",ürün :"+ob.getUrun()+" adet:"+ob.getAdet()).toList()).toList();
	}

	
	
	
}
