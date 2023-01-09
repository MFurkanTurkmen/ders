package com.furkan.soru4;

public class OtomobilFactorySingleton {
	
	private static OtomobilFactory otomobilFactory;
	
	public static OtomobilFactory createOtomobilFactory() {
		if(otomobilFactory==null) {
			otomobilFactory=new OtomobilFactory();
		}
		return otomobilFactory;
	}

}
