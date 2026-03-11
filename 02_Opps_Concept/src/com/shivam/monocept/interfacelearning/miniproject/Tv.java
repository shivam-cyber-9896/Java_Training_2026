package com.shivam.monocept.interfacelearning.miniproject;

public class Tv implements Controllable {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Tv is Turned on");
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Tv is turend off");
		
	}

	@Override
	public void setMode() {
		// TODO Auto-generated method stub
		System.out.println("Tv is set to Hd");
		
	}

}
