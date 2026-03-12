package com.shivam.monocept.abstractAssingment.model2;

public class Surgery extends HospitalService {
	double surgeryFee;
	public Surgery(String patientName, double consultationFee, double surgeryFee) throws InvalidServiceException {
		super(patientName, consultationFee);
		this.surgeryFee=surgeryFee;
		if(consultationFee<0)
			throw new InvalidServiceException("Consultation fee is less than 0 is not applicable");
		if(surgeryFee<0)
			throw new InvalidServiceException("surgery fee is less than 0 is not applicable");
	}

	@Override
	public double calculateTotalFee() {
		return consultationFee + surgeryFee;
	}

	@Override
	public boolean checkEligibility(double healthScore) {
		return healthScore > 50;
	}

	@Override
	public void displayDetails() {

		System.out.println("Service ID: " + serviceId);
		System.out.println("Patient Name: " + patientName);
		System.out.println("Consultation Fee: " + consultationFee);
		System.out.println(" total fee      : "+calculateTotalFee());
		System.out.println("Service Type: Surgery");
	}
}