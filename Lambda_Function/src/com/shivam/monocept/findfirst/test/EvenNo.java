package com.shivam.monocept.findfirst.test;

import java.util.List;
import java.util.Optional;

public class EvenNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Optional<Integer> FirstEven= List.of(1,2,3,4,5,6,7,8,9)
      .stream().filter(m->m%2==0)
      .findFirst();
     System.out.println("First even :"+FirstEven.get());
	}

}
