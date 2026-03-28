package com.shivam.monocept.map.test;

import java.util.List;

public class MultiplayBy10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   List.of(1,2,3,4,5,5,6,7,8,9).stream()
		   .map(i -> i*10)
		   .forEach(System.out::println);
	}

}
