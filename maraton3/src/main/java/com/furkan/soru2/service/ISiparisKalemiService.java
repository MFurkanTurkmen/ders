package com.furkan.soru2.service;

import java.util.List;

import com.furkan.soru2.entity.SiparisKalemi;

public interface ISiparisKalemiService {
	public void save(SiparisKalemi siparisKalemi);
	public void update(int id,SiparisKalemi siparisKalemi);
	public void delete(int id);
	public List<SiparisKalemi> findAll();
	public SiparisKalemi findById(int id);

}
