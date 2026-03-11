package com.shivam.monocept.ExceptionHandling.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.ExceptionHandling.model1.*;

public class StringPasswordCheckerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter password: ");
			String password = scanner.nextLine();
			StringPasswordChecker.checkPassword(password);
		} catch (InvalidPasswordException e) {
			System.out.println("Invalid Password: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Error: Please enter valid numeric values!" + e);
		} catch (Exception e) {
			System.out.println("Invalid input! Please enter a numeric value.");
		} 
	}

}
