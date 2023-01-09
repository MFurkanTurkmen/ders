package com.furkan.entity.Enum;

public enum EType {
	STUDENT("S"),
	TEACHER("T"),
	PRINCIPAL("P");
	
	private String type;
	
	EType(String type){
		this.type=type;
	}

	  public String getType() {
	        return type;
	    }
}
