package com.shivam.monocept.collectionassingment.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shivam.monocept.collectionassingment.model1.CandidatesComparable;
import com.shivam.monocept.collectionassingment.model2.FlightsbyFare;

public class FlightsbyFareTest {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Whats the No of Flight  do you want to sortBy fare");
		int i=scanner.nextInt();
		while(i<=1)
		{
			System.out.println("Enter a vaild no of above 1");
			 i=scanner.nextInt();
			 
		}
		scanner.nextLine();
		int n=0;
		List<FlightsbyFare> Flights= new ArrayList();
		while(n<i)
		{
			System.out.println("Enter a Airline");
			String airline=scanner.nextLine();
			System.out.println("Enter a Price");
			double price =scanner.nextDouble();
			scanner.nextLine();

			Flights.add(new FlightsbyFare(airline,price) );
			n++;
		}
	        Flights.sort(new FlightsbyFare() );
	        for(FlightsbyFare f: Flights)
	        {
	        	System.out.println("soreted by fare"+f);
	        }
	
	}
}
