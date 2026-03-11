package com.shivam.monocept.interfacelearning.miniproject;

public class Light implements Controllable{

	@Override
	public void turnOn() {
	System.out.println("Light is turn on");
		
	}

	@Override
	public void turnOff() {
		System.out.println("Light are turn off");
		
	}

	@Override
	public void setMode() {
		System.out.println("Setting Mode is Light is Dim Now");
	}

}
