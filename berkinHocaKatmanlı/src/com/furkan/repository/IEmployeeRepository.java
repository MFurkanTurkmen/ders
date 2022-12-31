package com.furkan.repository;

import java.sql.Connection;

import com.furkan.entity.Employee;

public interface IEmployeeRepository {
	
	
	public void insert(Employee emp);
	public void delete(Integer id);

}
