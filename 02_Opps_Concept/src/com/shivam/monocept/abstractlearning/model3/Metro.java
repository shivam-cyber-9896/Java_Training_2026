package com.shivam.monocept.abstractlearning.model3;

public class Metro extends Transport {
     private static String BaseFare="100";
     double Kilometer;
	public Metro(String Kilometer) {
		super(BaseFare);
		this.Kilometer=Double.parseDouble(Kilometer);
	}

	@Override
	double CalculateFare() {
		double fare=Double.parseDouble(BaseFare);
		fare = fare +Kilometer*15;
		return fare ;
	
	}

}
