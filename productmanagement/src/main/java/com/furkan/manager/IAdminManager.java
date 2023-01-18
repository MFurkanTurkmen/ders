package com.furkan.manager;

import java.util.List;

import com.furkan.entity.Admin;

public interface IAdminManager {
	public void save(Admin admin);
	public void update(long id, Admin admin);
	public void delete(Admin admin);
	public List<Admin> findAll();
	public Admin findById(long id);
	public List<Admin> findByNameLıke(String Name);

}
