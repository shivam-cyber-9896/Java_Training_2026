package com.shivam.monocept.string.test;

import java.util.Scanner;

import com.shivam.monocept.string.model1.SentanceFormater;

public class SentanceformaterTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String Sentance;
		System.out.println("Enter your Sentance ");
		Sentance=scanner.nextLine();
          SentanceFormater sentance=new SentanceFormater(Sentance);
          sentance.Formatter();
	}

}
