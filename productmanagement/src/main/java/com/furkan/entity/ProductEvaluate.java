package com.furkan.entity;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Entity
public class ProductEvaluate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String comment;
	private int puan;
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Customer customer;
	
	public ProductEvaluate(String comment, int puan, Product product,Customer customer) {
		super();
		this.comment = comment;
		this.puan = puan;
		this.product = product;
		this.customer=customer;
	}
	public ProductEvaluate() {
	}
	@Override
	public String toString() {
		return "ProductEvaluate [id=" + id + ", comment=" + comment + ", puan=" + puan + ", product=" + product +" customer= "+customer ;
	}
	
	
	

}
