package com.furkan.factory.land;

import com.furkan.factory.land.soldier.LandSeviye1;
import com.furkan.factory.land.soldier.LandSeviye2;
import com.furkan.factory.land.soldier.LandSeviye3;

public class LandFactory  {
	
	public ILandEnemy createEnemey(String enemyType) {
		
		if(enemyType ==null || enemyType.isEmpty() )
		{
			System.out.println("düşman seviyesi boş girilmiş");
		}
		
		switch (enemyType) {
		case "sopalı": {
			return new LandSeviye1();
			
		} case ILandEnemy.landSeviye2:{
			return new LandSeviye2();
		}case ILandEnemy.landSeviye3:{
			return new LandSeviye3();
		}
		
		
		default:
			throw new IllegalArgumentException("asker bilgisini yanlis girdin : asagidaki gibi bir değer girin \n1_" +ILandEnemy.landSeviye1 );
		}
	}

}
