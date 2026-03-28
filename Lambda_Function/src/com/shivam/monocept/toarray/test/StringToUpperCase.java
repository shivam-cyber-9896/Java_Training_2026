package com.shivam.monocept.toarray.test;

import java.util.List;

public class StringToUpperCase {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub
		String[] arr= List.of("hlo","Hye","Bye","hi","wow","cool").stream()
				.map(m->m.toUpperCase())
	    		  .toArray(String[]::new);
		for(String s:arr)
			System.out.println(s);
	}

}
