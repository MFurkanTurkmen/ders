package com.furkan.soru3;

public class MsjSubscriberHaberlesmeci implements ObsSonar,ObsYangin {


	@Override
	public void update(MsjSonar m) {
		System.out.println("!!! sonar uyarısı !!! haberleşmecinin dikkatine !!! "+m.getMessageContent());
		
		
	}

	@Override
	public void update(MsjYanginSensor m) {
		System.out.println("!!! yangın uyarısı !!! haberleşmecinin dikkatine !!!  "+m.getMessageContent());
		
	}


}
