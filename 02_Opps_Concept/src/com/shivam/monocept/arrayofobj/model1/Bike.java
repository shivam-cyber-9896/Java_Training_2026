package com.shivam.monocept.arrayofobj.model1;

 public class Bike extends Vehicle {

    public Bike(String vehicleNumber) {
		super(vehicleNumber);
		// TODO Auto-generated constructor stub
	}

	private static final double BASE_TOLL = 50;

  

    @Override
    public double calculateToll() {
        double toll = BASE_TOLL;
        updateTotals(toll);
        return toll;
    }
}
