package com.furkan.manager;

import java.util.List;

import com.furkan.entity.ProductEvaluate;

public interface IProductEvaluateManager {
	public void save(ProductEvaluate productEvaluate);
	public void update(long id, ProductEvaluate productEvaluate);
	public void delete(ProductEvaluate productEvaluate);
	public List<ProductEvaluate> findAll();
	public ProductEvaluate findById(long id);
	public List<ProductEvaluate> findByNameLıke(String Name);

}
