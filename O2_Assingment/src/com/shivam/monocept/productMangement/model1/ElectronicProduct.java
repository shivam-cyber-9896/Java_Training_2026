package com.shivam.monocept.productMangement.model1;

public class ElectronicProduct extends Product {
private double warranty;
private static double counter=11900;
	public ElectronicProduct(String productName, double basePrice,double warranty) {
		super(++counter, productName, basePrice);
		this.warranty=warranty;
	}

	@Override
	public void ShowDetail() {
		  System.out.println("Product ID: " + getProductId());
	        System.out.println("Product Name: " + getProductName());
	        System.out.println("Base Price: " + getBasePrice());
	        System.out.println("Warranty: " + warranty + " years");	
	}

	@Override
	public void CalculatePrice() {
		 double tax = getBasePrice() * 0.18;   
	        double finalPrice = getBasePrice() + tax;

	        System.out.println("Electronics Tax (18%): " + tax);
	        System.out.println("Final Price: " + finalPrice);
	}

}
