package com.shivam.monocept.supplier.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class CityProvider {


	public static void main(String[] argus) {
		  Supplier<String> defaultCity = () -> "Pune";
		  String userInput="";
		  String city=userInput;
		  if (userInput == null || userInput.trim().isEmpty()) {
			    city = defaultCity.get();
			}	  
	System.out.println("City :"+city);
	}
 	

}
