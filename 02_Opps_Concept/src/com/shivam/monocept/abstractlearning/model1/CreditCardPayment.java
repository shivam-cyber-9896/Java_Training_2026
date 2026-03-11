package com.shivam.monocept.abstractlearning.model1;

public class CreditCardPayment extends Payment {
	String CreditCardNumber;
	String Amount;
	public CreditCardPayment(String CreditCardNumber,String Amount){
		super(Amount);
		if (!validateAmount(Amount)) {
			System.out.println("Please enter a vaild amount  to genrate payment");
			return;
		}
		this.Amount=Amount;
		this.CreditCardNumber=CreditCardNumber;
	}
	double amt;
	@Override
	public
	void processPayment() {
		
	 amt = Double.parseDouble(Amount);
		amt = amt + (amt * 0.02);
		System.out.println("Processing Credit Card payment Payment...");
		System.out.println("Credit Card Payment: " + CreditCardNumber );
		System.out.println(" Processing Fee is Applicable as 2%");
		System.out.println("Total Amount Paid: ₹" + amt);
		
		
	}
	@Override
	public
	void generateReceipt() {
		System.out.println("------ Credit Card Payment RECEIPT ------");
        System.out.println("Credit Card Payment: " + CreditCardNumber);
        System.out.println("Total Amount Paid with 2% Fees: ₹" + amt);
        System.out.println("Payment Successful");
        System.out.println("-------------------------");
		
	}

}
