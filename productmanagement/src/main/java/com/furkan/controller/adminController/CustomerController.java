package com.furkan.controller.adminController;

import com.furkan.entity.Customer;
import com.furkan.manager.Impl.CustomerManager;

public class CustomerController {
	CustomerManager customerManager = new CustomerManager();
	
	public void findAll() {
		for (Customer ct : customerManager.findAll()) {
			System.out.println("name= "+ct.getName()+", last name= "+ct.getLastName()+", mail= "+ct.getEmail()+", sepet id"+ct.getSepet().stream().map(obj -> obj.getId()+", sepet durumu: "+obj.isAktifMi()).toList());
		}
	}
	
	public void findByNameLike(String name) {
		for(Customer ct : customerManager.findByNameLıke(name)) {
			System.out.println("name= "+ct.getName()+", last name= "+ct.getLastName()+", mail= "+ct.getEmail()+", sepet id"+ct.getSepet().stream().map(obj -> obj.getId()+", sepet durumu: "+obj.isAktifMi()).toList());
		}
	}

}
