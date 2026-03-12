
package com.shivam.monocept.viehcaleRegistration.model1;

public class Car extends Vehicle {

	private int numberOfSeats;

	public Car(String registrationNumber, String ownerName, double baseCharge, int hoursUsed, int numberOfSeats) {

		super(registrationNumber, ownerName, baseCharge, hoursUsed);
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public void showDetails() {

		System.out.println("Vehicle Type: Car");
		System.out.println("Registration Number: " + getRegistrationNumber());
		System.out.println("Owner Name: " + getOwnerName());
		System.out.println("Seats: " + numberOfSeats);
		System.out.println("Hours Used: " + getHoursUsed());
	}

	@Override
	public void calculateCharge() {
		double total = getBaseCharge() * getHoursUsed() + 200;
          
		

		System.out.println("Total Usage Charge: " + total);
	}
}