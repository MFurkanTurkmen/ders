package com.furkan.soru2.service;

import java.util.List;

import com.furkan.soru2.entity.Urun;
import com.furkan.soru2.repository.UrunRepository;

public class UrunService implements IUrunService {
	
	UrunRepository urunRepository;
	
	

	public UrunService() {
		this.urunRepository = new UrunRepository();
	}

	@Override
	public void save(Urun urun) {
		urunRepository.save(urun);		
	}

	@Override
	public void update(int id, Urun urun) {
		urunRepository.update(id, urun);		
	}

	@Override
	public void delete(int id) {
		urunRepository.delete(id);		
	}

	@Override
	public List<Urun> findAll() {
		return urunRepository.findAll();
	}

	@Override
	public Urun findById(int id) {
		return urunRepository.findById(id);
	}

}
