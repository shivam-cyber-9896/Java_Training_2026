package com.shivam.monocept.limit.test;

public class Product {
String Name;
int Price;
public Product(String name, int price) {
	
	Name = name;
	Price = price;
}
@Override
public String toString() {
	return "Product [Name=" + Name + ", Price=" + Price + "]";
}

}
