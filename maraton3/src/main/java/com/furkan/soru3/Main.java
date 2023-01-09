package com.furkan.soru3;

public class Main {

	
	public static void main(String[] args) {
		
		
		MsjSubscriberKaptan s1 = new MsjSubscriberKaptan();
		MsjSubscriberHaberlesmeci s2 = new MsjSubscriberHaberlesmeci();
		MsjSubscriberTorpidoMerkezi s3 = new MsjSubscriberTorpidoMerkezi();
	
		
		
		MsjPublisherOksijen p = new MsjPublisherOksijen();
		p.attach(s1);
		
		p.notifyUpdate(new MsjOksijenSensor("Düşük oksijen seviyesi!", 20, "Silah Binası"));
		
		System.out.println("\n ********* \n");
		
		MsjPublisherYangin p2 = new MsjPublisherYangin();
		p2.attach(s1);
		p2.attach(s2);
		
		p2.notifyUpdate(new MsjYanginSensor("Yangın alarmı aktif", 45, 70));
		
		System.out.println("\n ********* \n");
		
		
		MsjPublisherSonar p3 = new MsjPublisherSonar();
		p3.attach(s1);
		p3.attach(s2);
		p3.attach(s3);
		
		p3.notifyUpdate(new MsjSonar("Bilinmeyen denizaltı yaklaşıyor", "214 TN", 100, 60, 45));
	
	}

}
