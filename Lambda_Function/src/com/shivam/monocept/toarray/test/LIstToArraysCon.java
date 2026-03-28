package com.shivam.monocept.toarray.test;

import java.util.List;

public class LIstToArraysCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String[] arr= List.of("hlo","Hye","Bye","hi","wow","cool").stream()
    		  .toArray(String[]::new);
      
      for(String s: arr)
      {  System.out.println(s);}
	}

}
