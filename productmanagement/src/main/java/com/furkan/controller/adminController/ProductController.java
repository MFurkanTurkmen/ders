package com.furkan.controller.adminController;

import java.util.Scanner;

import com.furkan.entity.Category;
import com.furkan.entity.Product;
import com.furkan.entity.ProductEvaluate;
import com.furkan.entity.Product;
import com.furkan.manager.Impl.CategoryManager;
import com.furkan.manager.Impl.ProductManager;
import com.furkan.manager.Impl.SepetManager;

public class ProductController {
	
	ProductManager productManager = new ProductManager();
	SepetManager sepetManager = new SepetManager();
	CategoryManager categoryManager = new CategoryManager();
	Scanner src= new Scanner(System.in);
	
	public void saveProduct() {
		System.out.println("product name");
		String name= src.nextLine();
		System.out.println("product price");
		long price= src.nextLong();
		System.out.println("product stock");
		int stock = src.nextInt();
		System.out.println("product category-id");
		long id = src.nextLong();
		Category category = categoryManager.findById(id);
		Product product = new Product(name, price, stock, category);
		productManager.save(product);
	}
	
	public void update(long id) {
		Product product= productManager.findById(id);
		System.out.println("enter The new product name");
		String name = src.nextLine();
		product.setName(name);
		System.out.println("enter The new product price");
		long price = src.nextLong();
		product.setPrice(price);
		System.out.println("enter The new product stock");
		int stock = src.nextInt();
		product.setStock(stock);
		productManager.update(id, product);
		
	}
	
	public void delete(long id) {
		Product product = productManager.findById(id);
		productManager.delete(product);
		
	}
	
	public void findAll() {
		for (Product ct : productManager.findAll()) {
			System.out.println("product id= "+ct.getId()+", product name= "+ct.getName()+", product price= "+ct.getPrice()+", product stock= "+ct.getStock());
		}
	}
	public void comment() {
		System.out.println("hangi ürünün yorumunu görmek istersiniz : ");
		long id = src.nextLong();
		Product product=productManager.findById(id);
		
		for (ProductEvaluate comment :product.getProductEvaluate() ) {
			System.out.println("vote= "+comment.getPuan()+",  comment= "+comment.getComment()+", Customer= "+comment.getCustomer().getName());
		}
	}
	
	public void findByNameLike(String name) {
		for(Product ct : productManager.findByNameLıke(name)) {
			System.out.println(ct);
		}
	}

}
