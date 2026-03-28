package com.shivam.monocept.map.test;

import java.util.List;



public class ProductDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Product> list=List.of(new Product("Laptop", 70000),
	               new Product("Mouse", 400),
	               new Product("Keyboard", 800),
	               new Product("Pen Drive", 300),
	               new Product("Headphones", 1500));
	
	list.stream()
	.map(s ->   s.Price -s.Price*0.10)
	.forEach(System.out::println);
	}
}
