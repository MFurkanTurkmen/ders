package com.furkan.soru3;

import java.util.ArrayList;
import java.util.List;

public class MsjPublisherSonar implements SubjectSonar {

	
		
		private List<ObsSonar> observers = new ArrayList<>();
		
		@Override
		public void attach(ObsSonar o) {
			if(!observers.contains(o)) {
				observers.add(o);
			}
			
		}
	
		@Override
		public void detach(ObsSonar o) {
			if(observers.contains(o)) {
				observers.remove(o);
			}
			
		}
	
		@Override
		public void notifyUpdate(MsjSonar m) {
		for (ObsSonar o : observers) {
			o.update(m);
		}
			
	}


}
