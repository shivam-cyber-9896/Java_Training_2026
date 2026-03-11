package com.shivam.monocept.string.test;

import java.util.Scanner;

import com.shivam.monocept.string.model1.EmailInputVaildater;

public class EmailInputVaildaterTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String Email;
		System.out.println("Enter a Email ");
		Email=scanner.nextLine();
		EmailInputVaildater Validate = new EmailInputVaildater (Email);
		Validate.Vaildater();
	}

}
