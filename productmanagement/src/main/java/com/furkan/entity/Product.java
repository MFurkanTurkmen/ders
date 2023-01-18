package com.furkan.entity;

import java.util.List;import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private long price;
	private int stock;
	
	@OneToMany(mappedBy = "product")
	private List<ProductEvaluate> productEvaluate;
	
	@ManyToOne
	private Category category;

	public Product(String name, long price, int stock, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}

	public Product() {
		super();
	}

	public Product(long id, String name, long price, int stock, List<ProductEvaluate> productEvaluate,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.productEvaluate = productEvaluate;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product bilgileri: id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", productEvaluate="
				+ productEvaluate + ", category=" + category.getId()+", category name= " +category.getName();
	}




	
	

}
