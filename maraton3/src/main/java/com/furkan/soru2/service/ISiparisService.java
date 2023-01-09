package com.furkan.soru2.service;

import java.util.List;

import com.furkan.soru2.entity.Siparis;

public interface ISiparisService {
	public void save(Siparis siparis);
	public void update(int id,Siparis siparis);
	public void delete(int id);
	public List<Siparis> findAll();
	public Siparis findById(int id);

}
