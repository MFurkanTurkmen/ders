package com.furkan.manager.Impl;

import java.util.List;

import com.furkan.entity.Admin;
import com.furkan.manager.IAdminManager;
import com.furkan.repository.Impl.AdminRepository;
import com.furkan.utilty.Singleton;

public class AdminManager implements IAdminManager{
	AdminRepository adminRepository=Singleton.getAdminRepository();

	@Override
	public void save(Admin admin) {
		adminRepository.save(admin);
	}

	@Override
	public void update(long id, Admin admin) {
		adminRepository.update(id, admin);
		}

	@Override
	public void delete(Admin admin) {
		adminRepository.delete(admin);		
	}

	@Override
	public List<Admin> findAll() {
		return 	adminRepository.findAll(Admin.class);
	}

	@Override
	public Admin findById(long id) {
		return 	adminRepository.findById(Admin.class, id)
;
	}

	@Override
	public List<Admin> findByNameLıke(String name) {
		return adminRepository.findByNameLike(Admin.class, name);
	}

}
