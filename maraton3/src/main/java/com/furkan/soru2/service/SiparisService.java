package com.furkan.soru2.service;

import java.util.List;

import com.furkan.soru2.entity.Siparis;
import com.furkan.soru2.repository.SiparisRepository;

public class SiparisService implements ISiparisService {
	public SiparisRepository siparisRepository;
	
	public SiparisService( ) {
		super();
		this.siparisRepository = new SiparisRepository();
	}

	@Override
	public void save(Siparis siparis) {
		siparisRepository.save(siparis);		
	}

	@Override
	public void update(int id, Siparis siparis) {
		siparisRepository.update(id, siparis);		
	}

	@Override
	public void delete(int id) {
		siparisRepository.delete(id);		
	}

	@Override
	public List<Siparis> findAll() {
		return siparisRepository.findAll();
	}

	@Override
	public Siparis findById(int id) {
		return siparisRepository.findById(id);
	}

}
