package com.shivam.monocept.string.test;

import java.util.Scanner;

import com.shivam.monocept.string.model1.PasswordVaildater;


public class passwordVaidaterTest {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String Password;
		System.out.println("Enter a Password ");
		Password=scanner.nextLine();
		PasswordVaildater check=new PasswordVaildater(Password);
		check.vaildate();
	}
}
