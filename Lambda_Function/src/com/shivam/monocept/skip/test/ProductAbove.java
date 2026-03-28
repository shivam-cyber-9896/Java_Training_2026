package com.shivam.monocept.skip.test;

import java.util.List;



public class ProductAbove {

	public static void main(String[] args) {
		List<Product> list=List.of(new Product("Laptop", 70000),
	               new Product("Mouse", 400),
	               new Product("Keyboard", 800),new Product("Gaming Keyboard", 1800),new Product("Mouse", 800),
	               new Product("Pen Drive", 3230),
	               new Product("Headphones", 1500));
	
	
   list.stream().filter(m->m.Price>=500).skip(2)
   .forEach(System.out::println);
	}
}
