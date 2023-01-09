package com.furkan.soru2.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.furkan.soru2.entity.Musteri;
import com.furkan.soru2.entity.Siparis;
import com.furkan.soru2.entity.SiparisKalemi;
import com.furkan.soru2.entity.Urun;
import com.furkan.soru2.service.MusteriService;
import com.furkan.soru2.service.SiparisKalemiService;
import com.furkan.soru2.service.SiparisService;
import com.furkan.soru2.service.UrunService;

public class Main {
	public static void main(String[] args) {
		MusteriService musteriService = new MusteriService();
		UrunService urunService =new UrunService();
		SiparisKalemiService siparisKalemiService = new SiparisKalemiService();
		SiparisService siparisService = new SiparisService();
		
		//		----- MUSTERİ SAVE----	
		Musteri musteri = new Musteri("celal", "şengör");
		Musteri musteri2 = new Musteri("fatih", "altaylı");
		Musteri musteri3 = new Musteri("Asım", "sengör");
		Musteri musteri4 = new Musteri("ilber", "ortaylı");
		Musteri musteri5 = new Musteri("murat", "bardakçı");

		musteriService.save(musteri);
		musteriService.save(musteri2);
		musteriService.save(musteri3);
		musteriService.save(musteri4);
		musteriService.save(musteri4);

		//		----Musteri update----
//		Musteri musteriUpdate= new Musteri("ömer", "çakmakcı");
//		musteriService.update(7, musteriUpdate);
		
		//		---- MUSTERİ DELETE----
//		musteriService.delete(2);
		
		//		----Musteri Find ALL----
//		System.out.println(musteriService.findAll());

		//		----Musteri Find By ID----
//		System.out.println(musteriService.findById(3));
		
		//		----Urun save----
		Urun urun= new Urun("samsung s22", 33500);
		Urun urun2= new Urun("iphone 14 pro max", 57350);
		Urun urun3= new Urun("xiaomi mi 11pro", 28500);
		Urun urun4= new Urun("robot süpürge", 5500);
		Urun urun5= new Urun("kahve makinesi", 13550);
		urunService.save(urun);
		urunService.save(urun2);
		urunService.save(urun3);
		urunService.save(urun4);
		urunService.save(urun5);
		
		
		//		----Siparis kalemi save----
		SiparisKalemi siparisKalemi = new SiparisKalemi(urunService.findById(1), 3); 
		SiparisKalemi siparisKalemi2 = new SiparisKalemi(urunService.findById(2), 5); 
		SiparisKalemi siparisKalemi3 = new SiparisKalemi(urunService.findById(2), 3);
		SiparisKalemi siparisKalemi4 = new SiparisKalemi(urunService.findById(3), 2); 
		SiparisKalemi siparisKalemi5 = new SiparisKalemi(urunService.findById(4), 8); 
		SiparisKalemi siparisKalemi6 = new SiparisKalemi(urunService.findById(5), 5); 
//		List<SiparisKalemi> list = new ArrayList();
//		list.add(siparisKalemi5);
//		list.add(siparisKalemi6);
//
		siparisKalemiService.save(siparisKalemi);
		siparisKalemiService.save(siparisKalemi2);
		siparisKalemiService.save(siparisKalemi3);
		siparisKalemiService.save(siparisKalemi4);
		siparisKalemiService.save(siparisKalemi5);
		siparisKalemiService.save(siparisKalemi6);
//

		//		------ siparişe sipariş kalemi verme---
		Siparis siparis= new Siparis(musteriService.findById(1), Arrays.asList(siparisKalemiService.findById(1),siparisKalemiService.findById(2)));
		Siparis siparis2 = new Siparis(musteriService.findById(4), Arrays.asList(siparisKalemiService.findById(4)));
		Siparis siparis3 = new Siparis(musteriService.findById(4),Arrays.asList(siparisKalemiService.findById(3)) );

		
//		siparisService.findById(3).setSiparisKalemi(list);
		
		siparisService.save(siparis);
		siparisService.save(siparis2);
		siparisService.save(siparis3);
//

		
		//		----müsteriye sipariş verme----
		Musteri musteri23 = musteriService.findById(5);
		musteri.setSiparis(Arrays.asList(siparisService.findById(1),siparisService.findById(2)));
		musteriService.update(5, musteri);

		 		//2A_ sipariş içindeki bilgiler
		System.out.println("-------2_A-----");
		siparisService.findAll().forEach(System.out::println);
	

				// 2b_ müsteri siparisleri getirme-----
		System.out.println("-------2_B-----");
		musteriService.findAll().forEach(System.out::println);

	
				// 2c _ ---müşteri sipariş adet---
		System.out.println("-------2_C-----");
		musteriService.musteriSiparisleri();
		
				// 2d_ musşteri siparis id ye göre
		System.out.println("-------2_D-----");
		musteriService.musteriSiparisId();
		
		
		
		
		


		
	}

}
