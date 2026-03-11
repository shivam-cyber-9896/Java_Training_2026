package com.shivam.monocept.interfacelearning.model2;

public class Car implements Vehicle{
	   private String fuel;

	    public Car(String fuel) {
	        this.fuel = fuel;
	    }
	@Override
	   public void start() {
        System.out.println("Car is starting with key ignition...");
	
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping with brake...");
		
    }

	@Override
	public String petroltype() {
		
		return fuel;
	}

}
