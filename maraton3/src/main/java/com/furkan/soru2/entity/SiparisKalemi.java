package com.furkan.soru2.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiparisKalemi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int siparisKalemiId;
	
	int adet;
	
	@Column(nullable = true)
	int kalemToplamı;
	
	@OneToOne
	private Urun urun;
	


	
	
	public SiparisKalemi( Urun urun,int adet) {
		super();
		this.urun = urun;
		this.adet = adet;
		this.kalemToplamı= urun.getFiyat()*adet;

	}



	@Override
	public String toString() {
		return "SiparisKalemi [adet=" + adet + ", urun=" + urun + "]";
	}
	
	
	

}
