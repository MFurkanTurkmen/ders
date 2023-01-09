package com.furkan.soru2.service;

import java.util.List;

import com.furkan.soru2.entity.Urun;

public interface IUrunService {

	public void save(Urun urun);
	public void update(int id,Urun urun);
	public void delete(int id);
	public List<Urun> findAll();
	public Urun findById(int id);

}
