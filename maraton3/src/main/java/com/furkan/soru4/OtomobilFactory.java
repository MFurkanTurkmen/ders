package com.furkan.soru4;



public class OtomobilFactory {
	public IOtomobil createOtomobil (String otomobilType) {
		if(otomobilType==null || otomobilType.isEmpty()) {
			System.out.println("null dönüyor");
			return null;
		}
		switch (otomobilType) {
		case IOtomobil.SUV:
			return new Suv();
		case IOtomobil.SEDAN:
			return new Sedan();
		case IOtomobil.CABRIO:
			return new Cabrio();
		default:
			throw new IllegalArgumentException("araç bulunumadı: " + otomobilType);
		}
	}

}
