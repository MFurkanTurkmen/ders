package com.furkan.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Product> product;

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
	}

	public Category(long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category id=" + id + ", name=" + name  +", ürünler= "+product.stream().map(obj -> obj.getName()+"->fiyat:"+obj.getPrice()).toList();
	}
	
	
	

}
