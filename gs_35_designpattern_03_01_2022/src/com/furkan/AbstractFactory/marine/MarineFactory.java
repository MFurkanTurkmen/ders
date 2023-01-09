package com.furkan.AbstractFactory.marine;

import com.furkan.AbstractFactory.marine.soldier.MarineSeviye1;
import com.furkan.AbstractFactory.marine.soldier.MarineSeviye2;
import com.furkan.AbstractFactory.marine.soldier.MarineSeviye3;

public class MarineFactory {
	
	public IMarineEnemy createEnemy(String enemyType) {
		
		if(enemyType== null || enemyType.isEmpty()) {
			System.out.println("hata bos göndermissin");
		}
		
		switch (enemyType) {
		case IMarineEnemy.marineSeviye1: {
			return (IMarineEnemy) new MarineSeviye1();
			
		}case IMarineEnemy.marineSeviye2:{
			return (IMarineEnemy) new MarineSeviye2();
			
		} case IMarineEnemy.marineSeviye3:{
		return (IMarineEnemy) new MarineSeviye3();
		}
		default :
			throw new IllegalArgumentException("girilen düşman tipi bulunamadı seçin: \n1_ " + "xxx"+"\n2_  "+IMarineEnemy.marineSeviye2 +"\n3_ " +IMarineEnemy.marineSeviye3);
			
		}
		
	}

}
