package com.shivam.monocept.abstractAssingment.model2;

public class DiagnosticTest extends HospitalService {
	double dignosticFee;

	public DiagnosticTest(String patientName, double consultationFee, double dignosticFee)
			throws InvalidServiceException {
		super(patientName, consultationFee);
		if(consultationFee<0)
			throw new InvalidServiceException("Consultation fee is less than 0 is not applicable");
		if(dignosticFee<0)
			throw new InvalidServiceException("dignostic fee is less than 0 is not applicable");
		this.dignosticFee = dignosticFee;
		System.out.println("DiagnosticTest Constructor Executed");
	}

	@Override
	public double calculateTotalFee() {
		return consultationFee + dignosticFee;
	}

	@Override
	public boolean checkEligibility(double age) {
		return age > 5;
	}

	@Override
	public void displayDetails() {

		System.out.println("Service ID: " + serviceId);
		System.out.println("Patient Name: " + patientName);
		System.out.println("Consultation Fee: " + consultationFee);
		System.out.println(" total fee      : " + calculateTotalFee());
		System.out.println("Service Type: Diagnostic Test");
	}
}