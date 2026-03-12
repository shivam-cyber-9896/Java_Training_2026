package com.shivam.monocept.productMangement.model1;

public class ClothingProduct extends Product {


private String size;
private static double counter=101;
public ClothingProduct( String productName, double basePrice,String size) {
		super(++counter, productName, basePrice);
		this.size=size;
	}

@Override
public void ShowDetail() {
    System.out.println("Product ID: " + getProductId());
    System.out.println("Product Name: " + getProductName());
    System.out.println("Base Price: " + getBasePrice());
    System.out.println("Size: " + size);
}

@Override
public void CalculatePrice() {
    double tax = getBasePrice() * 0.05; 
    double finalPrice = getBasePrice() + tax;

    System.out.println("Clothing Tax (5%): " + tax);
    System.out.println("Final Price: " + finalPrice);
}
	
}
