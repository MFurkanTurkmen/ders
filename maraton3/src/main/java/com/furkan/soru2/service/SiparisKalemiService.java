package com.furkan.soru2.service;

import java.util.List;

import com.furkan.soru2.entity.SiparisKalemi;
import com.furkan.soru2.repository.SiparisKalemiRepository;

public class SiparisKalemiService implements ISiparisKalemiService{

	public SiparisKalemiRepository  siparisKalemiRepository;
	
	public SiparisKalemiService( ) {
		this.siparisKalemiRepository = new SiparisKalemiRepository();
	}

	@Override
	public void save(SiparisKalemi siparisKalemi) {
		siparisKalemiRepository.save(siparisKalemi);
		
	}

	@Override
	public void update(int id, SiparisKalemi siparisKalemi) {
		siparisKalemiRepository.update(id, siparisKalemi);	
	}

	@Override
	public void delete(int id) {
		siparisKalemiRepository.delete(id);		
	}

	@Override
	public List<SiparisKalemi> findAll() {
		return siparisKalemiRepository.findAll();
	}

	@Override
	public SiparisKalemi findById(int id) {
		return siparisKalemiRepository.findById(id);
	}

}
