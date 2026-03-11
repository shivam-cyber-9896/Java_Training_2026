package com.shivam.monocept.ExceptionHandling.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.ExceptionHandling.model1.Finally;
import com.shivam.monocept.ExceptionHandling.model1.ToCheckMarks;

public class ToCheckMarksTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		double Marks;
	
		try {
			System.out.println("Enter a Marks to Check Vaild");
			Marks=scanner.nextDouble();
			ToCheckMarks.CheckMarks(Marks);
		}
		
		 catch (IllegalArgumentException e) {
	            System.out.println("Marks Should In postive and betwwen 0 to100" + e.getMessage());
	        }
		 catch (InputMismatchException e) {
	            System.out.println("Error: Please enter valid numeric values!"+e);
	        }
	        catch (Exception e) {
	            System.out.println("Invalid input! Please enter a numeric value.");
	        }

	}

}
