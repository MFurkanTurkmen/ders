package com.furkan.threadsSoru.copy;

public class Sayici2 extends Thread {
	
	private String isim;

	public Sayici2(String isim) {
		this.isim = isim;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	
	//Yukarıda extend thread dedikten sonra sınıfa buraya gelip sağ tıklayıp override implements metotlardan run a bastık.
	@Override
	public void run() {
		System.out.println(this.isim + " isimli thread çalışıyor.");
		
		for (int i = 0; i < 51; i+=5) {
			System.out.println(isim + " yazıyor" + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println(this.isim + " isimli thread bitti, çıkıyor.");
		
	}
}
