package com.furkan.manager;

import java.util.List;

import com.furkan.entity.Sepet;

public interface ISepetManager {
	public void save(Sepet sepet);
	public void update(long id, Sepet sepet);
	public void delete(Sepet sepet);
	public List<Sepet> findAll();
	public Sepet findById(long id);
	public List<Sepet> findByNameLıke(String Name);

}
