package com.furkan.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkan.entity.Admin;
import com.furkan.entity.Category;
import com.furkan.entity.Customer;
import com.furkan.entity.Product;
import com.furkan.entity.ProductEvaluate;





public class HibernateUtils {

	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {

		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(Admin.class);
			configuration.addAnnotatedClass(Category.class);
			configuration.addAnnotatedClass(Customer.class);
			configuration.addAnnotatedClass(Product.class);
			configuration.addAnnotatedClass(ProductEvaluate.class);

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
