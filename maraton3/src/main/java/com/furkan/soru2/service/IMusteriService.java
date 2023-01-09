package com.furkan.soru2.service;

import java.util.List;

import com.furkan.soru2.entity.Musteri;

public interface IMusteriService {
	
	public void save(Musteri musteri);
	public void update(int id,Musteri musteri);
	public void delete(int id);
	public List<Musteri> findAll();
	public Musteri findById(int id);

}
