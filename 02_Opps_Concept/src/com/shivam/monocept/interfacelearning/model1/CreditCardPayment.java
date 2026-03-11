package com.shivam.monocept.interfacelearning.model1;

public class CreditCardPayment implements Payment {

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing Credit Card Payment of ₹" + amount);
		System.out.println("Credit Card Payment Successful!");
	}
}