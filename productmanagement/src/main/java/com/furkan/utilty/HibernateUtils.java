package com.furkan.utilty;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.furkan.entity.Admin;
import com.furkan.entity.Category;
import com.furkan.entity.Customer;
import com.furkan.entity.Product;
import com.furkan.entity.ProductEvaluate;
import com.furkan.entity.Sepet;

import com.furkan.entity.User;

public class HibernateUtils {

	
	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	
	private static SessionFactory sessionFactoryHibernate() {
		

			try {
			Configuration configuration = new Configuration();
			
		//üzerinde çalıştığımız classları gelip buraya ekliyoruz
			configuration.addAnnotatedClass(Admin.class);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Customer.class);
			configuration.addAnnotatedClass(Product.class);
			configuration.addAnnotatedClass(ProductEvaluate.class);
			configuration.addAnnotatedClass(Sepet.class);
			configuration.addAnnotatedClass(Category.class);

			



			
			
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
			
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}	
		
		return null;
	}


	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	
			

}
