package com.furkan.AbstractFactory.land.soldier;

import com.furkan.factory.land.ILandEnemy;

public class LandSeviye1 implements ILandEnemy{

	@Override
	public void attack() {

		System.out.println("seviye 1 sopayla saldırdı dikkat !!!");
	}

}
