package com.shivam.monocept.puc;

import java.util.Scanner;

public class MultiplayRunner {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a value");
		int a=scanner.nextInt();
		System.out.println("Enter a value b");
		int b =scanner.nextInt();
		Multiply mult=new Multiply() {

			public int operation(int a, int b) {
				return a*b;
			}
			
		};
		System.out.println("Result of fuctional interface "+mult.operation(a, b));
	}

}
