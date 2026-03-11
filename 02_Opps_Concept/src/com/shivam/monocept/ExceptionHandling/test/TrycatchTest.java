package com.shivam.monocept.ExceptionHandling.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.ExceptionHandling.model1.TryCatch;

public class TrycatchTest {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		try {
		System.out.println("Enter a Number A");
		int a=scanner.nextInt();
		System.out.println("Enter the number B");
		int b =scanner.nextInt();
	  TryCatch.divide(a,b);
			
		}
		catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!"+e);
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values!"+e);
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e);
        }
	}

}
