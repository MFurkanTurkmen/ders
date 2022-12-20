package com.furkan.inheritance.copy;

public class Muhendis extends Personel{

	private String uzmanlikAlani;

	
	public Muhendis (String ad, String soyad, String tcKimlik , int yas, int maas, int kidemBilgisi, long cepTelNo, String uzmanlikAlani) {
		super(ad, soyad, tcKimlik, yas, maas, kidemBilgisi, cepTelNo);
		this.setUzmanlikAlani(uzmanlikAlani);
		
	}
	
	public int getZamKatSayisi() {
		return 4;
	}
	

	
	public String getUzmanlikAlani() {
		return uzmanlikAlani;
	}

	public void setUzmanlikAlani(String uzmanlikAlani) {
		this.uzmanlikAlani = uzmanlikAlani;
	}
	
	
	
	
	
	
	
	
}
