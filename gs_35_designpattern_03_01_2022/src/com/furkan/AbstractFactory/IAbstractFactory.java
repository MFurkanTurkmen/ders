package com.furkan.AbstractFactory;

import com.furkan.AbstractFactory.land.ILandEnemy;
import com.furkan.AbstractFactory.land.LandFactory;
import com.furkan.factory.marine.IMarineEnemy;
import com.furkan.factory.marine.MarineFactory;

public abstract class IAbstractFactory {
	
	public static String landFactory="landfactory";
	public static String marineFactory="marinefactory";

	abstract ILandEnemy createLandFactory(); 
	abstract IMarineEnemy createMarineFactory();
}
