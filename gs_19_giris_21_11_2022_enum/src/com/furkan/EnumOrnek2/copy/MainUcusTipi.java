package com.furkan.EnumOrnek2.copy;

public class MainUcusTipi {

	
	
	
	public static void ucusBilgileriniGoster(UcusTipi ucusTipi) {
		System.out.println("Uçuş Tipi: " + ucusTipi.getTip() + " Uçuş Bilgisi: " + ucusTipi.getMetin());
	}
	
	
	
	
	public static void main(String[] args) {
	
		MainUcusTipi.ucusBilgileriniGoster(UcusTipi.EKONOMIK);
		MainUcusTipi.ucusBilgileriniGoster(UcusTipi.OZEL);
		MainUcusTipi.ucusBilgileriniGoster(UcusTipi.VIP);


	}

}
