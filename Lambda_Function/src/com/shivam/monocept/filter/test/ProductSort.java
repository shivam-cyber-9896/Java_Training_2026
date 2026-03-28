package com.shivam.monocept.filter.test;

import java.util.List;

public class ProductSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       List<Product> list=List.of(new Product("Laptop", 70000),
               new Product("Mouse", 400),
               new Product("Keyboard", 800),
               new Product("Pen Drive", 300),
               new Product("Headphones", 1500));
       list.stream()
       .filter(S -> S.Price >=500)
       .forEach(System.out::println);
	}

}
