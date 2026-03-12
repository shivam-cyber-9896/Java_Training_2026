package com.shivam.monocept.exceptionhandling.puc;

import java.util.Scanner;

public class TryWithResourcesPuc {
	public static void main(String[] argus)
	{
	 try(Scanner scanner=new Scanner (System.in)){
		System.out.println("ENTER a no a which can divsible by zero"); 
		int a=scanner.nextInt();
		int b=a/0;
		System.out.println("Error not occured");
	 }
	 catch(ArithmeticException e) {
		 System.out.println("Did not divide by zero");
	 }
	 catch (Exception e) {
         System.out.println("Unexpected Error" +e);
     }
	 finally {
		 System.out.println("program Close");
	 }
	}

}
