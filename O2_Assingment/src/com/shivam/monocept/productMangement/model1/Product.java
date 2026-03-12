package com.shivam.monocept.productMangement.model1;

public abstract class Product {
	private final double  productId;
	private  String productName;
	double basePrice;
  Product(double productId,String productName,double basePrice ){
	  this.productId=productId;
	  this.basePrice=basePrice;
	  this.productName=productName;
		}
  public abstract void ShowDetail();
  public abstract void CalculatePrice();
  public String getProductName() {
	return productName;
  }
  
  public double getProductId() {
	return productId;
}
  public double getBasePrice() {
	return basePrice;
  }
 
  
}
