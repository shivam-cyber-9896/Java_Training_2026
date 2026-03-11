package com.shivam.monocept.abstractlearning.model3;

public class Bus extends Transport{
       double Kilometer;
       static String BaseFare="50";
	public Bus(String Kilometer) {
		super(BaseFare);
		// TODO Auto-generated constructor stub
		this.Kilometer=Double.parseDouble(Kilometer);
	}

	@Override
	double CalculateFare() {
		// TODO Auto-generated method stub
		double fare=Double.parseDouble(BaseFare);
		fare = fare +Kilometer*10;
		return fare ;
	}

}
