package com.shivam.monocept.count.test;

import java.util.List;

public class EvenCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Long counter= List.of(1,2,3,4,5,6,7,8,9,10,11,22,3,3,45,643,53,2,22,545,6,57,7,5,64,1,54,2)
      .stream()
      .filter(s->s%2==0)
      .count();
     System.out.println("Total even  :"+counter);
	}

}
