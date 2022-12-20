package com.furkan.kendiExceptionSinifimiziYazmak.copy;

import java.util.Scanner;

public class Main {

	
	
	public static void hizKontrol(int hiz) {
		if (hiz > 120) {
			throw new AsiriHizException("Aşırı hız yapılmak isteniyor!!");
		}else {
			System.out.println("İyi yolculuklar...");
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Hızı giriniz: ");
		int hiz = sc.nextInt();
		
		
		Main.hizKontrol(hiz);      //Bu haline unchecked exception diyoruz. Ve bu şekilde throwsuz kullanabiliyoruz hata vermiyor
		
		
		try {
			Main.hizKontrol(hiz);
		} catch (AsiriHizException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Bye..");

	}

}
