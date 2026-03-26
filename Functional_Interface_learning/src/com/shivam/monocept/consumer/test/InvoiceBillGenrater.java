package com.shivam.monocept.consumer.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class InvoiceBillGenrater {

	public static void main(String[] args) {
	List<Invoice> store=Arrays.asList(
			new Invoice("Laptop",10,128),
			new Invoice("Air conditinor",20,11228),
			new Invoice("HeadPhone",101,12228)
			);
        Consumer<Invoice> print=p ->{
        	System.out.println("Welcome to Bill gentrater tool");
        	System.out.println("Product Name :"+p.itemName);
        	System.out.println("Prduct Quentity :"+p.quantity);
        	System.out.println("Product Price  :"+p.price);
        }; 
        for(Invoice i:store)
        	   print.accept(i);
	}

}
