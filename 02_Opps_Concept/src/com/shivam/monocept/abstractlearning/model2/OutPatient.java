package com.shivam.monocept.abstractlearning.model2;

public class OutPatient extends Patient {
	String consultancyFees;
	public OutPatient(String name,String consultancyFees) {
		super(name);
		this.consultancyFees=consultancyFees;
		
	}

	@Override
	public double calculateCharges() {
	double Fee=Double.parseDouble(consultancyFees);
		return Fee;
	}

}
