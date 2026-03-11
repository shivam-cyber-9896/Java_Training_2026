package com.shivam.monocept.abstractlearning.model3;

public abstract class Transport {
	 private final long routeId ;
	   private String BaseFare;
	   private static long counter=112;
	   Transport(String BaseFare){
		   this.BaseFare=BaseFare;
		   counter++;
		   routeId=counter;
	   }
	  abstract double CalculateFare();
	   public void PrintTicket() {
		   double fare=CalculateFare();
		   System.out.println("________________________________");
		   System.out.println("__________Printing Ticket_______");
		   System.out.println("Route id for your Jounery : "+routeId);
		   System.out.println("so Base Fare of your Journey"+BaseFare);
		   System.out.println("Total Fare Of Your jounery is : "+fare);
		   System.out.println("------------Happy Jounery---------------");
		   System.out.println("------------and Safe Jounery---------------");
	   }
}
