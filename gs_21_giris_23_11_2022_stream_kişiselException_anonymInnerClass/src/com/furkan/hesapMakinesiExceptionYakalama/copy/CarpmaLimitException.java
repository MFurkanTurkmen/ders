package com.furkan.hesapMakinesiExceptionYakalama.copy;




public class CarpmaLimitException extends Exception {

	
		//constructor atamadık, kendi constructor ını kullancak. Parametre almadık.
	
	@Override
	public void printStackTrace() {
		System.out.println("İki sayı da çok büyük, lütfen daha küçük sayılar giriniz!");
	}


	
	
	
	
	
	
	
	
	
	
}
