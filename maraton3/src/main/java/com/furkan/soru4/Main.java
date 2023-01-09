package com.furkan.soru4;

public class Main {
	public static void main(String[] args) {
		
		OtomobilFactorySingleton otomobilFactorySingleton= new OtomobilFactorySingleton();
		OtomobilFactory otomobilF=OtomobilFactorySingleton.createOtomobilFactory();
		
		otomobilF.createOtomobil(IOtomobil.CABRIO).drive();
		otomobilF.createOtomobil(IOtomobil.SUV).drive();
		otomobilF.createOtomobil(IOtomobil.SEDAN).drive();
	
		
	}

}
