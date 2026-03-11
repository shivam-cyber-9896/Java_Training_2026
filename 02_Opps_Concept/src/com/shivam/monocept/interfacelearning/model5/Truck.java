package com.shivam.monocept.interfacelearning.model5;

public class Truck implements VehicleControl {

	 
		@Override
		public void start() {
			// TODO Auto-generated method stub
			System.out.println("Truck is Started useing key");
			
		}

		@Override
		public void stop() {
			// TODO Auto-generated method stub
			System.out.println("Truck is stoped by appling brake");
			
		}

		@Override
		public void ChangeGear(int gear) {
			// TODO Auto-generated method stub
			System.out.println("We changed the Truck Gear to : "+gear);
		
	}

}
