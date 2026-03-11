package com.shivam.monocept.string.test;

import java.util.Scanner;

import com.shivam.monocept.string.model1.FileNameVaildater;

public class FileNameVaildaterTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String FileName;
		System.out.println("Enter a FileName ");
		FileName=scanner.nextLine();
		FileNameVaildater vaildate=new FileNameVaildater(FileName);
		vaildate.vaildate();
	}

}
