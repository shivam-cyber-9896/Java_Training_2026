package com.shivam.monocept.string.test;

import java.util.Scanner;

import com.shivam.monocept.string.model1.ReverseWord;

public class ReverseWordTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String sentance;
		System.out.println("Enter a Sentance ");
		sentance=scanner.nextLine();
		ReverseWord word=new ReverseWord(sentance);
	}

}
