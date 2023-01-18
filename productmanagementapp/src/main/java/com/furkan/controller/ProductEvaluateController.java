package com.furkan.controller;

import java.util.List;
import java.util.Optional;

import com.furkan.entity.Customer;
import com.furkan.entity.Product;
import com.furkan.entity.ProductEvaluate;
import com.furkan.service.ProductEvaluateService;
import com.furkan.service.ProductService;
import com.furkan.utils.BAUtils;

public class ProductEvaluateController {
	
	ProductEvaluateService productEvaluateService;
	ProductService productService;
	
	public ProductEvaluateController() {
		productEvaluateService = new ProductEvaluateService();
		productService = new ProductService();

	}
	

	public void comment(Customer customer) {
		
		List<Product> listProduct = customer.getProducts();
		listProduct.forEach(System.out::println);
		
		if(!(listProduct.isEmpty())) {
			long id = BAUtils.readLong("Please enter product id that you want to comment: ");
			int point = BAUtils.readInt("Please enter the point ");
			String comment = BAUtils.readString("Please enter comment for this product: ");
			
			long customerId = customer.getId();
			
			ProductEvaluate productEvaluate = productEvaluateService.listAll().stream()
					.filter((p) -> p.getProduct().getId() == id && p.getCustomer().getId() == customerId).findAny()
					.orElse(null);
			if(productEvaluate != null) {
				ProductEvaluate productEvaluate2 = new ProductEvaluate(comment, point, productService.find(id), customer);
				productEvaluateService.create(productEvaluate2);
			}else {
				System.out.println("You must have purchased the product before you can comment ");
			}
			
		}else {
			System.out.println("You must have purchased the product before you can comment ");
		}
		
		
	
		
	}


	public void commentListByProducts(Customer customer) {
		long id = BAUtils.readLong("Please enter product id that you want to see all comments: ");
		
		List<ProductEvaluate> commentList = productEvaluateService.listAll().stream().filter((a) -> a.getProduct().getId() == id).toList();
		if(!(commentList.isEmpty())) {
			System.out.println(commentList);
		}else {
			System.out.println("\nThere is no comment for this product.\n");
		}
		
	}

}
