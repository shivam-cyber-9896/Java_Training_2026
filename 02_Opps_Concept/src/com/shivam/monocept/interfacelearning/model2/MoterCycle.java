package com.shivam.monocept.interfacelearning.model2;

public class MoterCycle implements Vehicle {

	@Override
	
	   public void start() {
     System.out.println("Bike is starting with key ignition...");
	
 }

 @Override
 public void stop() {
     System.out.println("Bike is stopping with brake...");
		
 }

	@Override
	public String petroltype() {
		// TODO Auto-generated method stub
		return "Petrol";
	}

}
