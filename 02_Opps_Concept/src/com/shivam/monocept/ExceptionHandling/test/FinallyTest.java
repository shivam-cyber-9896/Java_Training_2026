package com.shivam.monocept.ExceptionHandling.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.ExceptionHandling.model1.Finally;

public class FinallyTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		double Balance;
		Finally Withdrow=new Finally();
		try {
			System.out.println("Enter a Balance to Withdrow ");
			Balance=scanner.nextDouble();
			Withdrow.Withdrow(Balance);
		}
		
		 catch (ArithmeticException e) {
	            System.out.println("Transaction Failed: " + e.getMessage());
	        }
		 catch (InputMismatchException e) {
	            System.out.println("Error: Please enter valid numeric values!"+e);
	        }
	        catch (Exception e) {
	            System.out.println("Invalid input! Please enter a numeric value.");
	        }

	        finally {
	            System.out.println("Transaction session ended.");
	            scanner.close();
	        }

}
}
