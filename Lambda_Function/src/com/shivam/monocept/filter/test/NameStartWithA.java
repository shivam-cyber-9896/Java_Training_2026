package com.shivam.monocept.filter.test;

import java.util.List;
import java.util.stream.Stream;

public class NameStartWithA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   List<String> list=List.of("Arun","Taruna","Akash","Abhishek","Preet","Anu","Shivam");
   Stream<String> StartWithA=list.stream(); 
		   StartWithA.filter(S-> S.startsWith("A"))
		   .forEach(System.out::println);
   
	}

}
