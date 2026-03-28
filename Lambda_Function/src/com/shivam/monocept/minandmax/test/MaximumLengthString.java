package com.shivam.monocept.minandmax.test;

import java.util.Comparator;
import java.util.List;

public class MaximumLengthString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     List<String> list=List.of("apple","capple","mappple"); 
     
     String word=list.stream()
    		 .max(Comparator.comparing(String::length))
    		 .get();
     System.out.println("Maximum Length word   "+word);
	
	}

}
