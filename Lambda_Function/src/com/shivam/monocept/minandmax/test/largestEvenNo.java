package com.shivam.monocept.minandmax.test;

import java.util.Comparator;
import java.util.List;

public class largestEvenNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          List.of(1,5,2,3,3,4,5,66,77,7,5,89,3,2,91,2,100)
        		  .stream().filter(m->m%2==0)
        		  .max(Comparator.naturalOrder())
        		  .ifPresent(System.out::println);
	}

}
