package com.shivam.monocept.ExceptionHandling.model1;

public class MultCatchBlock {
public static void main(String[] argus) {
	String[] str=new String[2] ;
	try {
	String s=str[5];
	}
	catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("You are taking those element which are not presenr in a string"+e);
	}
	str=null;
	try {
		int x=str.length;
	}
	catch(NullPointerException e) {

		System.out.println("If string is why are you taking length of it"+e);
}
}
}
