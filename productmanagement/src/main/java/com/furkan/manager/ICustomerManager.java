package com.furkan.manager;

import java.util.List;

import com.furkan.entity.Customer;

public interface ICustomerManager {
	public void save(Customer customer);
	public void update(long id, Customer customer);
	public void delete(Customer customer);
	public List<Customer> findAll();
	public Customer findById(long id);
	public List<Customer> findByNameLıke(String Name);

}
