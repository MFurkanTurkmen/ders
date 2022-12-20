package com.furkan.polymorphism.ornek2.copy;

public class Kedi extends Hayvan {

	
	public Kedi(String ad, int kilosu, int uzunlugu) 
	{
		super(ad, kilosu, uzunlugu);	
	}
	
	public void sesCikar() 
	{
		System.out.println("Miyavvvv...");
	}

}
