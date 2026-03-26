package com.shivam.monocept.collectionassingment.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shivam.monocept.collectionassingment.model4.ProductSort;

public class ProductSortTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("How many product do you want to create");
		int i=scanner.nextInt();
		while(i<=1)
		{
			System.out.println("Enter a vaild no of above 1");
			 i=scanner.nextInt();
			 
		}
		scanner.nextLine();
		int n=0;
		List<ProductSort> product=new ArrayList();
		while(n<i)
		{
			System.out.println("Enter a Product Catogary");
			String catogary=scanner.nextLine();
			System.out.println("Enter a product name");
			String name=scanner.nextLine();
			System.out.println("Enter Price");
			double price =scanner.nextDouble();
			
			scanner.nextLine();
			product.add(new ProductSort(catogary,name,price));
			n++;

	}
		product.sort(new ProductSort());
		for(ProductSort p:product)
		{
			System.out.println(""+p);
		}
	
	}

}
