package com.furkan.singleton;

public class Main {

	public static void main(String[] args) {
		
		Islemler islem= new Islemler();
		System.out.println(islem.cevreHesaplama(10, 5));
		System.out.println(islem.alanHesapama(10, 5));

	}

}
