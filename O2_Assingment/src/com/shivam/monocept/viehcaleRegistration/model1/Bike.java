package com.shivam.monocept.viehcaleRegistration.model1;


public class Bike extends Vehicle {

	private int engineCC;

	public Bike(String registrationNumber, String ownerName, double baseCharge, int hoursUsed, int engineCC) {

		super(registrationNumber, ownerName, baseCharge, hoursUsed);
		this.engineCC = engineCC;
	}

	@Override
	public void showDetails() {

		System.out.println("Vehicle Type: Bike");
		System.out.println("Registration Number: " + getRegistrationNumber());
		System.out.println("Owner Name: " + getOwnerName());
		System.out.println("Engine CC: " + engineCC);
		System.out.println("Hours Used: " + getHoursUsed());
	}

	@Override
	public void calculateCharge() {

		double total = getBaseCharge() * getHoursUsed() + 100;

		System.out.println("Total Usage Charge: " + total);
	}
}