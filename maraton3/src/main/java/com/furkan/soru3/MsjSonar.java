package com.furkan.soru3;

public class MsjSonar {

	final String messageContent; 
	final String dusmanDenizaltiTipi;
	final int dusmanDenizaltiUzaklik;
	final int dusmanDenizaltiHiz;
	final int dusmanDenizaltiYon;
	
	
	public MsjSonar(String m, String dusmanDenizaltiTipi, int dusmanDenizaltiUzaklik,
			int dusmanDenizaltiHiz, int dusmanDenizaltiYon) {
		super();
		this.messageContent = m;
		this.dusmanDenizaltiTipi = dusmanDenizaltiTipi;
		this.dusmanDenizaltiUzaklik = dusmanDenizaltiUzaklik;
		this.dusmanDenizaltiHiz = dusmanDenizaltiHiz;
		this.dusmanDenizaltiYon = dusmanDenizaltiYon;
	} 
	


	public String getMessageContent() {
		return messageContent;
	}

	public String getDusmanDenizaltiTipi() {
		return dusmanDenizaltiTipi;
	}

	public int getDusmanDenizaltiUzaklik() {
		return dusmanDenizaltiUzaklik;
	}

	public int getDusmanDenizaltiHiz() {
		return dusmanDenizaltiHiz;
	}

	public int getDusmanDenizaltiYon() {
		return dusmanDenizaltiYon;
	}

	@Override
	public String toString() {
		return "MessageSonar [messageContent=" + messageContent + ", dusmanDenizaltiTipi=" + dusmanDenizaltiTipi
				+ ", dusmanDenizaltiUzaklik=" + dusmanDenizaltiUzaklik + ", dusmanDenizaltiHiz=" + dusmanDenizaltiHiz
				+ ", dusmanDenizaltiYon=" + dusmanDenizaltiYon + "]";
	} 

	
	
	
}
