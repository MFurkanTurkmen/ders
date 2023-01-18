package com.furkan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Admin extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	final private EStatus status=EStatus.ADMIN;

	

	public Admin(String name, String lastName, String email, String password) {
		super(name, lastName, email, password);
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String lastName, String email, String password, long id) {
		super(name, lastName, email, password);
		this.id = id;
	}

	@Override
	public String toString() {
		return "Admin bilgileri : id=" + id + ", status=" + status + ", name=" + getName() + ", last name="
				+ getLastName() + ", email" + getEmail() + ", password=" + getPassword() ;
	}
	
	
	
	
	
	
	

}
