package com.shivam.monocept.abstractlearning.model1;

public class upiPayment extends Payment {
	String UpiId;
	String Amount;

public	upiPayment(String Id, String Amount) {
		super(Amount);
		if (!validateAmount(Amount)) {
			System.out.println("Please enter a vaild amount  to genrate payment");
			return;
		}
		this.Amount = Amount;
		this.UpiId = Id;
		
	}

	@Override
	public void processPayment() {
		
		double amt = Double.parseDouble(Amount);

		System.out.println("Processing UPI Payment...");
		System.out.println("UPI ID: " + UpiId);
		System.out.println("No Processing Fee");
		System.out.println("Total Amount Paid: ₹" + amt);
	}

	@Override
	public void generateReceipt() {
		System.out.println("------ UPI RECEIPT ------");
        System.out.println("UPI ID: " + UpiId);
        System.out.println("Amount Paid: ₹" + Amount);
        System.out.println("Payment Successful");
        System.out.println("-------------------------");
	}

}
