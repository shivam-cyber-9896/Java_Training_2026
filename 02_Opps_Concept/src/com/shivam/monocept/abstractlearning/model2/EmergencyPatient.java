package com.shivam.monocept.abstractlearning.model2;

public class EmergencyPatient extends Patient {
	String EmergencyFees;
	public EmergencyPatient(String name,String EmergencyFees) {
		super(name);
		this.EmergencyFees=EmergencyFees;
	}

	@Override
	public double calculateCharges() {
	double fee=Double.parseDouble(EmergencyFees);
		return fee;
	}

}
