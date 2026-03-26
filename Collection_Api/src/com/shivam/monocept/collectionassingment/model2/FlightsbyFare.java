package com.shivam.monocept.collectionassingment.model2;

import java.util.Comparator;

public class FlightsbyFare implements Comparator<FlightsbyFare> {
	String airline;
	double fare;
	public FlightsbyFare(String airline,double fare)
	{
		this.airline=airline;
		this.fare=fare;
	}
	public FlightsbyFare() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compare(FlightsbyFare o2, FlightsbyFare o1) {
		
		return Double.compare(o1.getFare(), o2.getFare());
	}
	@Override
	public String toString() {
		return "FlightsbyFare [airline=" + airline + ", fare=" + fare + "]";
	}
	public double getFare() {
		return fare;
	}
	

}
