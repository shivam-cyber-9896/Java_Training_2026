package com.shivam.monocept.string.test;

import java.util.Scanner;

import com.shivam.monocept.string.model1.ProductCodeParser;

public class ProductCodeParserTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String ProductCode;
		System.out.println("Enter a ProductCode ");
		ProductCode=scanner.nextLine();
		ProductCodeParser code=new ProductCodeParser(ProductCode);
		code.Checker();
	}

}
