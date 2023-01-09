package com.furkan.soru3;

public class MsjSubscriberTorpidoMerkezi implements ObsSonar {

	@Override
	public void update(MsjSonar m) {
		System.out.println("sonar da uyarııı !!! torpido merkeznin dikkatine : "+m.getMessageContent());
		
		
	}


}
