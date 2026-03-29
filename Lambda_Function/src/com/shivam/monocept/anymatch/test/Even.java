package com.shivam.monocept.anymatch.test;

import java.util.List;

public class Even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       boolean haseven = List.of(1,2,3,4,5,6,7,8,9,10).stream()
       .anyMatch(S->S%2==0);
       System.out.println(haseven);
	}

}
