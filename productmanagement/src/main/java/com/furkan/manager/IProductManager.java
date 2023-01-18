package com.furkan.manager;

import java.util.List;

import com.furkan.entity.Product;

public interface IProductManager {
	public void save(Product product);
	public void update(long id, Product product);
	public void delete(Product product);
	public List<Product> findAll();
	public Product findById(long id);
	public List<Product> findByNameLıke(String Name);

}
