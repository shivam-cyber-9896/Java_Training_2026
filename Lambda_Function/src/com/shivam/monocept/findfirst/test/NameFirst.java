package com.shivam.monocept.findfirst.test;

import java.util.List;
import java.util.Optional;

public class NameFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Optional<String> firstName=  List.of("Names","first","String").stream()
      .findFirst();
      System.out.println(firstName);
	}
	

}
