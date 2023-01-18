package com.furkan.controller.customerController;

import java.util.List;

import com.furkan.entity.Customer;
import com.furkan.entity.Sepet;
import com.furkan.manager.Impl.CategoryManager;
import com.furkan.manager.Impl.CustomerManager;
import com.furkan.manager.Impl.ProductEvaluateManager;
import com.furkan.manager.Impl.ProductManager;
import com.furkan.manager.Impl.SepetManager;

public class CustomerController {
	static SepetManager sepetManager = new SepetManager();
	static CategoryManager categoryManager= new CategoryManager();
	static ProductManager productManager = new ProductManager();
	static ProductEvaluateManager productEvaluateManager= new ProductEvaluateManager();
	static CustomerManager customerManager = new CustomerManager();
	static Sepet sepet;
	static Customer customer;
	public static void createCart(Customer customer) {
		
		sepet = new Sepet(customer, true);
		sepetManager.save(sepet);
	}
	public static void addProductToCart(Sepet sepet) {
		for(List<Sepet> listSepet: customerManager.findAll().stream().map(obj -> obj.getSepet()).toList()) {
			if()
		}
		
		
	}
	

}
