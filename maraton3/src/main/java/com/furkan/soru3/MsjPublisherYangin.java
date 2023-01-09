package com.furkan.soru3;

import java.util.ArrayList;
import java.util.List;

public class MsjPublisherYangin implements SubjectYangin {
	
	private List<ObsYangin> observers = new ArrayList<>();

	@Override
	public void attach(ObsYangin o) {
		if(!observers.contains(o)) {
			observers.add(o);
		}
		
	}

	@Override
	public void detach(ObsYangin o) {
		if(observers.contains(o)) {
			observers.remove(o);
		}
		
	}

	@Override
	public void notifyUpdate(MsjYanginSensor m) {
		for (ObsYangin o : observers) {
			o.update(m);
		}
	}




}
