package com.shivam.monocept.abstractlearning.model3;

public class Taxi  extends Transport{

	private static String BaseFare="200";
    double Kilometer;
	public Taxi(String Kilometer) {
		super(BaseFare);
		this.Kilometer=Double.parseDouble(Kilometer);
	}

	@Override
	double CalculateFare() {
		double fare=Double.parseDouble(BaseFare);
		fare = fare +Kilometer*30;
		return fare ;
	
	}


}
