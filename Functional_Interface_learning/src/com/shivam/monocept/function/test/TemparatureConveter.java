package com.shivam.monocept.function.test;

import java.util.Scanner;
import java.util.function.Function;

public class TemparatureConveter {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter a value");
		double temperture=scanner.nextDouble();
		Function<Double,Double> converter=F -> (F * 9/5)+32;
		System.out.println("Temperature in celsius"+temperture);
		System.out.println("Temperature in Faranite :"+converter.apply(temperture));
	}
}
