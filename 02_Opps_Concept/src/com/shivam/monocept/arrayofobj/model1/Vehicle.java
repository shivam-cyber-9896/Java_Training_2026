package com.shivam.monocept.arrayofobj.model1;

public class Vehicle {

    public String vehicleNumber;

    
    public static int totalVehiclesProcessed = 0;
   private static double totalTollCollected = 0;

    public static double getTotalTollCollected() {
	return totalTollCollected;
}


  


	public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    
    public double calculateToll() {
        return 0; 
    }

    public double calculateToll(double distance) {
        return 0;
    }

 
    protected void updateTotals(double toll) {
        totalVehiclesProcessed++;
        totalTollCollected += toll;
    }
}
