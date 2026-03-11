package com.shivam.monocept.arrayofobj.model1;

public class Truck extends Vehicle {

    private double loadWeight;

    public Truck(String vehicleNumber, double loadWeight) {
        super(vehicleNumber);
        this.loadWeight = loadWeight;
    }

    
    public double calculateToll() {
        double toll = 200 + (loadWeight * 10);
        updateTotals(toll);
        return toll;
    }

}
