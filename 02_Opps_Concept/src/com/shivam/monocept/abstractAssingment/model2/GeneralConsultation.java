package com.shivam.monocept.abstractAssingment.model2;

public class GeneralConsultation extends HospitalService {

	public GeneralConsultation(String patientName, double consultationFee) throws InvalidServiceException {
		super(patientName, consultationFee);
		if(consultationFee<0)
			throw new InvalidServiceException("Consultation fee is less than 0 is not applicable");
	}

	@Override
	public double calculateTotalFee() {
		return consultationFee;
	}

	@Override
	public boolean checkEligibility(double age) {
		return age > 0;
	}

	@Override
	public void displayDetails() {

		System.out.println("Service ID: " + serviceId);
		System.out.println("Patient Name: " + patientName);
		System.out.println("Consultation Fee: " + consultationFee);
		System.out.println("Service Type: General Consultation");
	}
}