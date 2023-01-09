package com.furkan.soru3;

public interface SubjectYangin {

	void attach(ObsYangin o);

    void detach(ObsYangin o);

    void notifyUpdate(MsjYanginSensor m);
	
}
