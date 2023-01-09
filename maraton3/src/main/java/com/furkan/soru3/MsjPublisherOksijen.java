package com.furkan.soru3;

import java.util.ArrayList;
import java.util.List;

public class MsjPublisherOksijen implements SubjectOksijen {
	
	private List<ObsOksijen> observers = new ArrayList<>();

	@Override
	public void attach(ObsOksijen o) {
		if(!observers.contains(o)) {
			observers.add(o);
		}
		
	}

	@Override
	public void detach(ObsOksijen o) {
		if(observers.contains(o)) {
			observers.remove(o);
		}
		
	}

	@Override
	public void notifyUpdate(MsjOksijenSensor m) {
		for (ObsOksijen o : observers) {
			o.update(m);
		}
	}



}
