package com.furkan.soru2.service;

import java.util.List;

import com.furkan.soru2.entity.Musteri;
import com.furkan.soru2.repository.MusteriRepository;

public class MusteriService implements IMusteriService {
	public MusteriRepository musteriRepository;
	
	public MusteriService() {
		this.musteriRepository=new MusteriRepository();
		
	}
	@Override
	public void save(Musteri musteri) {
		musteriRepository.save(musteri);
	}

	@Override
	public void update(int id, Musteri musteri) {

		musteriRepository.update(id, musteri);
	}

	@Override
	public void delete(int id) {
		musteriRepository.delete(id);
		
	}

	@Override
	public List<Musteri> findAll() {
		return musteriRepository.findAll();
	}

	@Override
	public Musteri findById(int id) {
		return musteriRepository.findById(id);
	}

	public void musteriSiparisleri() {
		musteriRepository.musteriSiparisleri();;
		
	}
	
	public void musteriSiparisId() {
		musteriRepository.musteriSiparisId();;
		
	}


}
