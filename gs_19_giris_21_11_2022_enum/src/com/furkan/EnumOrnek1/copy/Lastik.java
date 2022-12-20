package com.furkan.EnumOrnek1.copy;

import com.furkan.EnumOrnek1.copy.EnumOrnek1.Mevsimler;

public class Lastik {

	
	
	public Mevsimler lastikMevsimi;
	
	public static void main(String[] args) {
		
		Lastik lastik = new Lastik();
		lastik.lastikMevsimi = Mevsimler.KIŞ;
		
		System.out.println(lastik.lastikMevsimi);
		
		
		
	}
	
	
	
	
	
	
}
