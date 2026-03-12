package com.shivam.monocept.viehcaleRegistration.model1;



public abstract class Vehicle {

	private String registrationNumber;
	private String ownerName;
	private double baseCharge;
	private int hoursUsed;

	public Vehicle(String registrationNumber, String ownerName, double baseCharge, int hoursUsed) {

		this.registrationNumber = registrationNumber;
		this.ownerName = ownerName;
		this.baseCharge = baseCharge;
		this.hoursUsed = hoursUsed;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBaseCharge() {
		return baseCharge;
	}

	public int getHoursUsed() {
		return hoursUsed;
	}

	public abstract void showDetails();

	public abstract void calculateCharge();
}