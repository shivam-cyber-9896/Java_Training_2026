package com.shivam.monocept.abstractlearning.model2;

  public abstract class Patient {
	   private final long patientId ;
	   private String name;
	   private static long counter=0101;
	  public Patient( String name) {
	        this.patientId = ++counter;
	        this.name = name;
	    }

	   
	    public void generateBill() {

	        double charges = calculateCharges();   
	        double tax = charges * 0.10;           
	        double finalAmount = charges + tax;    

	        System.out.println("\nPatient ID: " + patientId);
	        System.out.println("Patient Name: " + name);
	        System.out.println("Charges: " + charges);
	        System.out.println("Tax (10%): " + tax);
	        System.out.println("Final Amount: " + finalAmount);
	    }

	 
	    public abstract double calculateCharges();
}
