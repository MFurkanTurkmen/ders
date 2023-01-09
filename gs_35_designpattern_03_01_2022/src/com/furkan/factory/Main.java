package com.furkan.factory;

import com.furkan.factory.land.LandFactory;
import com.furkan.factory.marine.IMarineEnemy;
import com.furkan.factory.marine.MarineFactory;

public class Main {
	public static void main(String[] args) {
		
		// ---------------her düşman için ayrı factory kullanarak yapılanlar------------------- 
		
		LandFactory factory = new LandFactory();
		factory.createEnemey("sopalı").attack();
		
		MarineFactory marineFactory = new MarineFactory();
		marineFactory.createEnemy(IMarineEnemy.marineSeviye3).attack(); // hem böyle çağırabilirsin
		marineFactory.createEnemy("acemimarine").attack();  			// hemde böyle çağırabilirsin
		//---------------------------------------
		
		
		
		
	}
}
