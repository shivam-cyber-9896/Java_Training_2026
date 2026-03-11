package com.shivam.monocept.arrayofobj.model1;


 public class Car extends Vehicle {

    private static final double FIXED_TOLL = 100;

    public Car(String vehicleNumber) {
        super(vehicleNumber);  
    }

    @Override
    public double calculateToll() {
        double toll = FIXED_TOLL;
        updateTotals(toll);
        return toll;
    }
}