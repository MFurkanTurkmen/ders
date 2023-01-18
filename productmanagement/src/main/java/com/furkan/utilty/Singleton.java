package com.furkan.utilty;

import com.furkan.entity.Category;
import com.furkan.repository.Impl.AdminRepository;
import com.furkan.repository.Impl.CategoryRepository;
import com.furkan.repository.Impl.CustomerRepository;
import com.furkan.repository.Impl.ProductEvaluateRepository;
import com.furkan.repository.Impl.ProductRepository;
import com.furkan.repository.Impl.SepetRepository;

public class Singleton {
	public static AdminRepository adminRepository;
	public static CustomerRepository customerRepository;
	public static SepetRepository sepetRepository;
	public static ProductRepository productRepository;
	public static ProductEvaluateRepository ProductEvaluateRepository;
	public static CategoryRepository categoryRepository;

	
	public static AdminRepository getAdminRepository() {
		if(adminRepository==null) {
			return new AdminRepository();
		}
		return adminRepository;
		
	}
	public static CustomerRepository getCustomerRepository() {
		if(customerRepository==null) {
			return new CustomerRepository();
		}
		return customerRepository;
	}

	public static SepetRepository getSepetRepository() {
		if(sepetRepository==null) {
			return new SepetRepository();
		}
		return sepetRepository;
	}
	
	public static ProductRepository getProductRepository() {
		if(productRepository==null) {
			return new ProductRepository();
		}
		return productRepository;
	}
	
	public static ProductEvaluateRepository getProductEvaluateRepository() {
		if(ProductEvaluateRepository==null) {
			return new ProductEvaluateRepository();
		}
		return ProductEvaluateRepository;
	}
	
	public static CategoryRepository getCategoryRepository() {
		if(categoryRepository==null) {
			return new CategoryRepository();
		}
		return categoryRepository;
	}
	
	
	
	
}


