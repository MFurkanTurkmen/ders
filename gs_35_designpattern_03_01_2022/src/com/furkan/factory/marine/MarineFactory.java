package com.furkan.factory.marine;

import com.furkan.factory.marine.soldier.MarineSeviye1;
import com.furkan.factory.marine.soldier.MarineSeviye2;
import com.furkan.factory.marine.soldier.MarineSeviye3;

public class MarineFactory {
	
	public IMarineEnemy createEnemy(String enemyType) {
		
		if(enemyType== null || enemyType.isEmpty()) {
			System.out.println("hata bos göndermissin");
		}
		
		switch (enemyType) {
		case IMarineEnemy.marineSeviye1: {
			return new MarineSeviye1();
			
		}case IMarineEnemy.marineSeviye2:{
			return new MarineSeviye2();
			
		} case IMarineEnemy.marineSeviye3:{
		return new MarineSeviye3();
		}
		default :
			throw new IllegalArgumentException("girilen düşman tipi bulunamadı seçin: \n1_ " + "xxx"+"\n2_  "+IMarineEnemy.marineSeviye2 +"\n3_ " +IMarineEnemy.marineSeviye3);
			
		}
		
	}

}
