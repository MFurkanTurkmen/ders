package com.furkan.AbstractFactory.land.soldier;

import com.furkan.factory.land.ILandEnemy;

public class LandSeviye2 implements ILandEnemy{

	@Override
	public void attack() {

		System.out.println("seviye 2 kılıcıyla saldırdı!!! alarm");
	}

}
