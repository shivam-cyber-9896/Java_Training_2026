package com.shivam.monocept.map.test;

import java.util.List;

public class Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     List<Integer>list= List.of(2,3,3,4,5,6,7,8,9,12,18);
     List<Integer> Square=list.stream()
    		 .map(m->m*m)
    		 .toList();
    System.out.println(Square); 
	
	}

}
