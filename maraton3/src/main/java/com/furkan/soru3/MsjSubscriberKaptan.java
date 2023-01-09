package com.furkan.soru3;

public class MsjSubscriberKaptan implements ObsSonar,ObsOksijen,ObsYangin {

	@Override
	public void update(MsjSonar m) {
		System.out.println("!!! sonar uyarısı !!! kaptanın dikkatine !!! " + m.getMessageContent());
		
	}
	@Override
	public void update(MsjOksijenSensor m) {
		System.out.println("!!! oksijen uyarısı !!! kaptanın dikkatine !!!  : "+ m.getMessageContent());
		
	}
	
	@Override
	public void update(MsjYanginSensor m) {
		System.out.println("!!! yangin uyarısı !!! kaptanın dikkatine !!! "+ m.getMessageContent());
		
	}
}
