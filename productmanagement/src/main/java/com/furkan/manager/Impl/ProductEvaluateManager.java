package com.furkan.manager.Impl;

import java.util.List;

import com.furkan.entity.ProductEvaluate;
import com.furkan.manager.IProductEvaluateManager;
import com.furkan.repository.Impl.ProductEvaluateRepository;
import com.furkan.utilty.Singleton;

public class ProductEvaluateManager implements IProductEvaluateManager {
	ProductEvaluateRepository productEvaluateRepository= Singleton.getProductEvaluateRepository();
	
	@Override
	public void save(ProductEvaluate productEvaluate) {
		productEvaluateRepository.save(productEvaluate);
	}

	@Override
	public void update(long id, ProductEvaluate productEvaluate) {
		productEvaluateRepository.update(id, productEvaluate);
		}

	@Override
	public void delete(ProductEvaluate productEvaluate) {
		productEvaluateRepository.delete(productEvaluate);		
	}

	@Override
	public List<ProductEvaluate> findAll() {
		return 	productEvaluateRepository.findAll(ProductEvaluate.class);
	}

	@Override
	public ProductEvaluate findById(long id) {
		return 	productEvaluateRepository.findById(ProductEvaluate.class, id)
;
	}

	@Override
	public List<ProductEvaluate> findByNameLıke(String name) {
		return productEvaluateRepository.findByNameLike(ProductEvaluate.class, name);
	}

}
