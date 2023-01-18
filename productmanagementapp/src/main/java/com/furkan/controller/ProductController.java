package com.furkan.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.furkan.entity.Category;
import com.furkan.entity.Customer;
import com.furkan.entity.Product;
import com.furkan.entity.ProductEvaluate;
import com.furkan.service.CategoryService;
import com.furkan.service.CustomerService;
import com.furkan.service.ProductService;
import com.furkan.utils.BAUtils;

public class ProductController {

	ProductService productService;
	CategoryService categoryService;
	CustomerService customerService;
	
	public ProductController() {
		productService = new ProductService();
		categoryService = new CategoryService();
		customerService = new CustomerService();
	}
	
	public void create() {
		
		String name = BAUtils.readString("Please enter product name: ");
		double price = BAUtils.readDouble("Please enter the product price: ");
		int stock = BAUtils.readInt("Please enter number of stock: ");
		
		System.out.println("\n Category List");
		categoryService.listAll();
		
		long id = BAUtils.readLong("Please enter category id: ");
		Category category = categoryService.find(id);
		
		Product product = new Product(name, price, stock, category);
		
		productService.create(product);
		
	}

	public void buyProduct(Customer customer) {
		productService.listAll();
		List<Product> basket = new ArrayList<>();
		List<Product> customerProducts = customer.getProducts();
		long id;
		
		boolean control = true;
		
		do {
			id = BAUtils.readLong("Please enter product id that you want to buy ");
			int quantity = BAUtils.readInt("Please enter quantity ");
			
			Product product = productService.find(id);
			
			
			if(!(quantity > product.getStock())) {
				product.setStock(product.getStock() - quantity);
				productService.update(id, product);
				customerProducts.add(product);
				
				basket.add(product);
			
			}else {
				System.out.println("There is only " + product.getStock() + " amount left.");
			}
			
			boolean control2 = true;
			while (control2) {
			System.out.println("Do you want to continue shopping?");
			String answer = BAUtils.readString("Y/N");

				if(answer.equalsIgnoreCase("Y")) {
					
					control2 = false;
					control = true;
				}else if (answer.equalsIgnoreCase("N")) {
					control2 = false;
					control = false;
				}else {
					System.out.println("Please enter Y/N");
					control2 = true;
				}
			}
	
		} while (control);

		
		if(!(basket.isEmpty())) {
				customer.setProducts(customerProducts);
				System.out.println(customerProducts);
				customerService.update(customer.getId(), customer);
		}
	}
	
	
	
	public boolean buyingControl(long id, int quantity) {
		Product product = productService.find(id);
		if(quantity > productService.find(id).getStock()) {
			return false;
		}else {
			
			product.setStock(product.getStock() - quantity);
			productService.update(id, product);
			System.out.println("buying control");
			return true;
		}
		
		
	}

	public void listAll() {
		productService.listAll();
		
	}

	public void outOfStock() {
		List<Product> stockList = productService.listAll2().stream().filter(product -> product.getStock() < 10).toList();
		stockList.forEach(System.out::println);	

	}
	


}
