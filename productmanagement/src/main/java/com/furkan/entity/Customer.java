package com.furkan.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Customer extends User {
	@Id
	private long tc;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	final private EStatus status=EStatus.CUSTOMER;
	
	@OneToMany(mappedBy = "customer")
	private List<Sepet> sepet;

	@OneToMany(mappedBy = "customer")
	private List<ProductEvaluate> productEvaluate;
	
	public Customer(String name, String lastName, String email, String password, long tc) {
		super(name, lastName, email, password);
		this.tc = tc;
	}
	
	public Customer(String name, String lastName, String email, String password) {
		super(name, lastName, email, password);
		this.sepet = sepet;
	}

	
	public Customer() {
	}



	@Override
	public String toString() {
		return "Customer Bilgileri:  id&tc =" + tc + " "+ "status=" + status  + ", name="
				+ getName() + ", last name=" + getLastName() + ", email=" + getEmail() + ", password="
				+ getPassword() +  ", sepet=" + sepet.stream().toList();
	}










	
	
	
	
	

	
	

	
	
	
	
	
}
