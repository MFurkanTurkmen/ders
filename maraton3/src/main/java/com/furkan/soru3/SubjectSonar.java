package com.furkan.soru3;

public interface SubjectSonar {
	public void attach(ObsSonar o);
	public void detach(ObsSonar o);
	public void notifyUpdate(MsjSonar m);
}
