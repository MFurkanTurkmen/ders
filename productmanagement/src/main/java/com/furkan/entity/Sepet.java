package com.furkan.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sepet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToMany
	private List <Product> product;

	private boolean aktifMi=true;

	public Sepet(Customer customer) {
		this.customer = customer;
	}
	

	public Sepet(Customer customer, boolean aktifmi) {
		this.customer = customer;
		this.aktifMi = aktifmi;
	}


	public Sepet() {
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
