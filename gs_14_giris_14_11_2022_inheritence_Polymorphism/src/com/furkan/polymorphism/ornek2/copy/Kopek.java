package com.furkan.polymorphism.ornek2.copy;

public class Kopek extends Hayvan {

	public Kopek(String ad, int kilosu, int uzunlugu) {
		super(ad, kilosu, uzunlugu);		
	}
	
	public void sesCikar() {
		System.out.println("Hav hav hav...");
	}

}
