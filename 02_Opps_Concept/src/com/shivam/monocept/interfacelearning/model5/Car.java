package com.shivam.monocept.interfacelearning.model5;

public class Car implements VehicleControl  {
 
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Car is Started useing key");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Car is stoped by appling brake");
		
	}

	@Override
	public void ChangeGear(int gear) {
		// TODO Auto-generated method stub
		System.out.println("We changed the car Gear to : "+gear);
		
	}

}
