package com.furkan.manager.Impl;

import java.util.List;

import com.furkan.entity.Customer;
import com.furkan.manager.ICustomerManager;
import com.furkan.repository.Impl.CustomerRepository;
import com.furkan.utilty.Singleton;

public class CustomerManager implements ICustomerManager {
	CustomerRepository customerRepository =  Singleton.getCustomerRepository();
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void update(long id, Customer customer) {
		customerRepository.update(id, customer);
		}

	@Override
	public void delete(Customer customer) {
		customerRepository.delete(customer);		
	}

	@Override
	public List<Customer> findAll() {
		return 	customerRepository.findAll(Customer.class);
	}

	@Override
	public Customer findById(long id) {
		return 	customerRepository.findById(Customer.class, id)
;
	}

	@Override
	public List<Customer> findByNameLıke(String name) {
		return customerRepository.findByNameLike(Customer.class, name);
	}

}
