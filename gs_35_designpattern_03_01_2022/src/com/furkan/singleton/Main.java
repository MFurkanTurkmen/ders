package com.furkan.singleton;

import com.furkan.singleton.util.Singleton;

public class Main {

	public static void main(String[] args) {
		
		Islemler islem= Singleton.islemler();
		System.out.println(islem.cevreHesaplama(10, 5));
		System.out.println(islem.alanHesapama(10, 5));

	}

}
