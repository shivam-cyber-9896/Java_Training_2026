package com.shivam.monocept.count.test;

import java.util.List;


public class ProductCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Product> list=List.of(new Product("Laptop", 700),
	               new Product("Mouse", 400),
	               new Product("Keyboard", 800),
	               new Product("Pen Drive", 300),
	               new Product("Headphones", 1500));
		 long counter=list.stream()
				 .map(m->m.Price-m.Price*0.20)
				 .filter(price -> price >= 500)
				 .count();
		 System.out.println("Above 500 Product count is :"+counter);
	}

}
