package com.furkan;

import java.util.Arrays;

import com.furkan.entity.Admin;
import com.furkan.entity.Category;
import com.furkan.entity.Customer;
import com.furkan.entity.Product;
import com.furkan.entity.ProductEvaluate;
import com.furkan.entity.Sepet;
import com.furkan.manager.Impl.AdminManager;
import com.furkan.manager.Impl.ProductManager;
import com.furkan.repository.Impl.AdminRepository;
import com.furkan.repository.Impl.CategoryRepository;
import com.furkan.repository.Impl.CustomerRepository;
import com.furkan.repository.Impl.ProductEvaluateRepository;
import com.furkan.repository.Impl.ProductRepository;
import com.furkan.repository.Impl.SepetRepository;

public class Main {
	public static void main(String[] args) {
		CustomerRepository customerRepository = new CustomerRepository();
		AdminRepository adminRepository = new AdminRepository();
		ProductEvaluateRepository productEvaluateRepository = new  ProductEvaluateRepository();
		ProductRepository productRepository= new ProductRepository();
		CategoryRepository categoryRepository = new CategoryRepository();
		SepetRepository sepetRepository = new SepetRepository();
		
		AdminManager adminManager= new AdminManager();
		
		
		
		
		// ------- SAVE -----------
//		Customer customer = new Customer("furkan", "türkmen", "fk@gmail.com", "asd123asd", 111343111);
//		Customer customer2 = new Customer("ilber", "ortaylı", "ilber@gmail.com", "asd123asd", 222434122);
//		Customer customer3 = new Customer("fatih", "altaylı", "farih@gmail.com", "asd123asd", 33333433);
//		Customer customer4 = new Customer("celal ", "şengör", "celal@gmail.com", "asd123asd", 444443444);
//		Customer customer5 = new Customer("albert", "einstein", "albert@gmail.com", "asd123asd", 55512555);
//		Customer customer6 = new Customer("nikola", "tesla", "nikola@gmail.com", "asd123asd", 66563);
//		Customer customer7 = new Customer("marie", "curie", "marie@gmail.com", "asd123asd", 77775);
//
//		customerRepository.save(customer);
//		customerRepository.save(customer2);
//		customerRepository.save(customer3);
//		customerRepository.save(customer4);
//		customerRepository.save(customer5);
//		customerRepository.save(customer6);
//		customerRepository.save(customer7);
		
		//------- UPDATE----------
//		Customer customer7 = new Customer("mustafa", "kemal", "mustafa@gmail.com", "asd123asd",77775);
//		customerRepository.update(77775,customer7);
		
		// ------FİND ALL -----------
//		for (Customer string : customerRepository.findAll(Customer.class)) {
//			System.out.println(string);	}
		
		// -----FIND BY ID -------------
//		System.out.println(customerRepository.findById(Customer.class, 77775));
		
		// ---- FIND BY NAME
//		for (Customer string :customerRepository.findByNameLike(Customer.class,"a")) {
//			System.out.println(string);		}
		
		
		// --------admin save---------
//		Admin admin = new Admin("İmparator", "Fatih", "kral.com", "asxdwe");
//		Admin admin2= new Admin("prens dune", "çöllü", "dune.com", "xnh4daa");
//		Admin admin3 = new Admin("Aragonr ", "numenor", "aragorn.com", "4f31cx");
//
//		adminRepository.save(admin);
//		adminRepository.save(admin2);
//		adminRepository.save(admin3);
//		for (Admin admin : adminRepository.findAll(Admin.class)) {
//			System.out.println(admin); 		}
		
		// ------category save-----------
//		Category category= new Category("tablet");
//		categoryRepository.save(category);
//		System.out.println(categoryRepository.findById(Category.class, 2));
		
		//----- ürün save--------
//		Product product = new  Product("xiaomi telefon", 14355, 25, categoryRepository.findById(Category.class, 3));
//		productRepository.save(product); // categori otomatik ürünleri tutar
		
		// ---- catergory list all---
//		for (Category string : 		categoryRepository.findAll(Category.class)) {
//			System.out.println(string);
//		}
		
		//---- CATERGORY UPDATE----
//		Category category = categoryRepository.findById(Category.class, 2);
//		category.setName("monitör");
//		categoryRepository.update(2, category);
		// ----ÜRÜN YORUMU----
//		ProductEvaluate productEvaluate = new ProductEvaluate("telefon çok çok kötü", 3, productRepository.findById(Product.class,19),customerRepository.findById(Customer.class, 55512555));
//		productEvaluateRepository.save(productEvaluate);
		
		// -----SEPET OLUSTURMA-----
//		Sepet sepet = new Sepet(customerRepository.findById(Customer.class, 77775));
//		sepetRepository.save(sepet);
		
//		Sepet sepet2=sepetRepository.findById(Sepet.class, 3);
//		sepet2.setProduct(Arrays.asList(productRepository.findById(Product.class, 2)));
//		sepetRepository.update(3, sepet2);
		
//		Admin admin= new Admin("Acun", "ılıcalı","acunn@hotmail.com", "acunn");
//		adminManager.save(admin);
		
//		for (Admin string : adminManager.findAll()) {
//			System.out.println(string);
//		}
//		
//		System.out.println("id ile arama: "+ adminManager.findById(2));
//		System.out.println("isim ile arama"+adminManager.findByNameLıke("a"));
		
	}
}
