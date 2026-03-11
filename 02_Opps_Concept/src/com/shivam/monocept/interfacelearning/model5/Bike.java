package com.shivam.monocept.interfacelearning.model5;

public class Bike implements VehicleControl {

	 
		@Override
		public void start() {
			// TODO Auto-generated method stub
			System.out.println("Bike is Started useing key");
			
		}

		@Override
		public void stop() {
			// TODO Auto-generated method stub
			System.out.println("Bike is stoped by appling brake");
			
		}

		@Override
		public void ChangeGear(int gear) {
			// TODO Auto-generated method stub
			System.out.println("Bike changed the Bike Gear to : "+gear);
	}

}
