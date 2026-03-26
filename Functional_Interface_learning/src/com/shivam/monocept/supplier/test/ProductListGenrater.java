package com.shivam.monocept.supplier.test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
public class ProductListGenrater {

	public static void main(String[] args) {
		Supplier<List<String>> list=() -> Arrays.asList("Laptop","Tv","Computer","Driyer","HeadPhone");
		 List<String> products = list.get();

	      
	        for (String product : products) {
	            System.out.println(product);
	        }
	}

}
