package com.shivam.monocept.string.test;

import java.util.Scanner;

import com.shivam.monocept.string.model1.WordFrequencyCounter;


public class WordFrequencyCounterTest {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String Sentance;
		System.out.println("Enter your Sentance ");
		Sentance=scanner.nextLine();
		WordFrequencyCounter count= new WordFrequencyCounter(Sentance);
		count.counter();
	}
}
