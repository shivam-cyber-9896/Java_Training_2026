package com.shivam.monocept.skip.test;

import java.util.List;

public class EvenNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   List.of(12,23,451,2,3,4,5,6,6,7,8,8,9,10,15,16,17,18,19).stream()
   .filter(m->m%2==0).skip(2)
   .forEach(System.out::println);
	}

}
