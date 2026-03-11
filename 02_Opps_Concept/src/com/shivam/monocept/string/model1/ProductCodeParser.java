package com.shivam.monocept.string.model1;

public class ProductCodeParser {
	String ProductCode;
	 String Category ;
	 String Productname ;
	String Manufacturingyear ;
	public ProductCodeParser(String ProductCode)
	{
		this.ProductCode=ProductCode;
	}
public	 void Checker() {
		  String[] parts = ProductCode.split("-");
		  Category=parts[0];
		  Productname=parts[1];
		  Manufacturingyear=parts[2];
		  Category = Category.toUpperCase();

	   
	        boolean TV = Productname.startsWith("TV");

	      
	        boolean year = Manufacturingyear.endsWith("2023");
	        print(TV,year);
	 }
	 private void print(boolean tV, boolean year) {
		 String modifiedCode = ProductCode.replace("-", " ");

	       

	       
	        System.out.println("Category: " + Category);
	        System.out.println("Product: " + Productname);
	        System.out.println("Year: " + Manufacturingyear);
	        System.out.println("Starts with TV: " +tV);
	        System.out.println("Ends with 2023: " + year);
	        System.out.println("Modified Code: " + modifiedCode);
	     
		
	 }

}
