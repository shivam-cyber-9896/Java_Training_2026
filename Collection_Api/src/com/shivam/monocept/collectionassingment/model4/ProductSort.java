package com.shivam.monocept.collectionassingment.model4;

import java.util.Comparator;

public class ProductSort implements Comparator<ProductSort>{
   String Catogary;
   String Name; 
   double price;
   
	public String getCatogary() {
	return Catogary;
}

  

   public double getPrice() {
	return price;
   }


	public ProductSort(String catogary, String name, double price) {
	
	this.Catogary = catogary;
	this.Name = name;
	this.price = price;
}



	public ProductSort() {
		// TODO Auto-generated constructor stub
	}



	@Override
public String toString() {
	return "ProductSort [Catogary=" + Catogary + ", Name=" + Name + ", price=" + price + "]";
}



	@Override
	public int compare(ProductSort P1, ProductSort P2) {
		int compare=P1.getCatogary().compareTo(P2.Catogary);
		if(compare!=0)
			return compare;
		return Double.compare(P1.getPrice(), P2.getPrice());
	}

}
