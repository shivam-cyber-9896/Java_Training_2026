package com.shivam.monocept.abstractlearning.model2;

public class InPatient extends Patient{
	String roomCharges;
	public InPatient(String name,String roomCharges) {
		super(name);
	   this.roomCharges=roomCharges;
	}

	@Override
	public double calculateCharges() {
		double fee=Double.parseDouble(roomCharges);
		return fee;
	}

	
}
