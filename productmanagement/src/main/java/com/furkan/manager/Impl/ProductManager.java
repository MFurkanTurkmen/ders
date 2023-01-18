package com.furkan.manager.Impl;

import java.util.List;

import com.furkan.entity.Product;
import com.furkan.manager.IProductManager;
import com.furkan.repository.Impl.ProductRepository;
import com.furkan.utilty.Singleton;

public class ProductManager implements IProductManager {

	ProductRepository productRepository= Singleton.getProductRepository();
	
	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void update(long id, Product product) {
		productRepository.update(id, product);
		}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);		
	}

	@Override
	public List<Product> findAll() {
		return 	productRepository.findAll(Product.class);
	}

	@Override
	public Product findById(long id) {
		return 	productRepository.findById(Product.class, id)
;
	}

	@Override
	public List<Product> findByNameLıke(String name) {
		return productRepository.findByNameLike(Product.class, name);
	}
	
}
