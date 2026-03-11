package com.shivam.monocept.exceptionhandling.puc;

import java.util.Scanner;

class ShivamException extends Exception{

	public ShivamException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	
}
public class ThrowCustemException {
	public static void main(String[] argus) {
		Scanner scanner =new Scanner(System.in);
	try {
		System.out.println("Enter a number Zero to seee Custem exceptiom");	
		int x=scanner.nextInt();
			if(x<1)
			{	throw new ShivamException("To see my custem  Exception");}}
				
	catch(ShivamException e)
	{
		System.out.println("My Custem exception is created"+e);
	}
	}

}
