package com.shivam.monocept.map.test;

public class Product {
String Name;
int Price;
public Product(String name, int price) {
	
	Name = name;
	Price = price;
}
@Override
public String toString() {
	return "Product After 10% Discount [Name=" + Name + ", Price=" + Price + "]";
}

}
