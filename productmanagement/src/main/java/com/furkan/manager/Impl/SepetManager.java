package com.furkan.manager.Impl;

import java.util.List;

import com.furkan.entity.Sepet;
import com.furkan.manager.ISepetManager;
import com.furkan.repository.Impl.SepetRepository;
import com.furkan.utilty.Singleton;

public class SepetManager implements ISepetManager {
	
	SepetRepository sepetRepository = Singleton.getSepetRepository();
	
	@Override
	public void save(Sepet sepet) {
		sepetRepository.save(sepet);
	}

	@Override
	public void update(long id, Sepet sepet) {
		sepetRepository.update(id, sepet);
		}

	@Override
	public void delete(Sepet sepet) {
		sepetRepository.delete(sepet);		
	}

	@Override
	public List<Sepet> findAll() {
		return 	sepetRepository.findAll(Sepet.class);
	}

	@Override
	public Sepet findById(long id) {
		return 	sepetRepository.findById(Sepet.class, id)
;
	}

	@Override
	public List<Sepet> findByNameLıke(String name) {
		return sepetRepository.findByNameLike(Sepet.class, name);
	}

}
