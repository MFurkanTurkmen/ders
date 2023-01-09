package com.furkan.AbstractFactory;

import com.furkan.AbstractFactory.land.LandFactory;
import com.furkan.AbstractFactory.marine.MarineFactory;

public class FactoryCreate {
	private static LandFactory landFactory;
	private static MarineFactory marineFactory;
	
	
	public IAbstractFactory createFactory(String factoryName) {
		if(factoryName==null || factoryName.isEmpty()) {
			System.out.println("factory name i girmediniz...");
		}
		switch (IAbstractFactory) {
		case IAbstractFactory.: {
			
			yield type;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + IAbstractFactory);
		}
		
		return null;
		
	}

}
