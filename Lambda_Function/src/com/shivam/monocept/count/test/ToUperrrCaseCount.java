package com.shivam.monocept.count.test;

import java.util.List;

public class ToUperrrCaseCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    long counter =List.of("aman ","abhi","tanya","allo","anaya","shanya").stream()
    		.map(m->m.toUpperCase())
    		.filter(f ->f.startsWith("A"))
    		.count();
    System.out.println("How many start with A :"+counter);
	}

}
