package com.furkan.singleton.util;

import com.furkan.singleton.Islemler;

public class Singleton {
	private static Islemler islemler;


	public static Islemler islemler() {
		if(islemler==null) {
			islemler= new Islemler();
		}
		return islemler;
	}
}
