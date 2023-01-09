package com.furkan.soru3;

public interface SubjectOksijen {

	void attach(ObsOksijen o);

    void detach(ObsOksijen o);

    void notifyUpdate(MsjOksijenSensor m);
	
}
