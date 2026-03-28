package com.shivam.monocept.count.test;

import java.util.List;

public class oddevencounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         List<Integer> list=List.of(1,2,3,4,5,6,7,8,9,10,11,233,456,674,12);
         Long evencounter=list.stream().filter(s->s%2==0)
        		 .count();
         System.out.println("Total length of list"+list.size());
         System.out.println("Even elements  "+evencounter);
         System.out.println("Odd counter "+(list.size()-evencounter));
	}

}
