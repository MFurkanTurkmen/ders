package com.furkan.polymorphism.ornek2.copy;

public class Kus extends Hayvan {

	public Kus(String ad, int kilosu, int uzunlugu) {
		super(ad, kilosu, uzunlugu);
	}
	
	public void sesCikar()
	{
		System.out.println("Cik cik cik...");
	}

}
