package com.shivam.monocept.abstractlearning.model1;

public class WalletPayment extends Payment{
	String WalletAddress;
	String Amount;
	double amt;
	public WalletPayment(String WalletAddress,String Amount){
		super(Amount);
		this.Amount=Amount;
		if (!validateAmount(Amount)) {
			System.out.println("Please enter a vaild amount  to genrate payment");
			return;
		}
		this.WalletAddress=WalletAddress;
	}
	
	@Override
	public
	void processPayment() {
		 amt = Double.parseDouble(Amount);
		amt = amt + (amt * 0.01);
		System.out.println("Processing Wallet Payment...");
		System.out.println("Wallet Address: " + WalletAddress);
		System.out.println(" Processing Fee is Applicable as 1%");
		System.out.println("Total Amount Paid: ₹" + amt);
		
	}
	@Override
	public
	void generateReceipt() {
		System.out.println("------ Wallet Payment RECEIPT ------");
        System.out.println("Wallet Address: " + WalletAddress);
        System.out.println("Amount Paid with 1% transaction Fees is: ₹" + amt);
        System.out.println("Payment Successful");
        System.out.println("-------------------------");
	}

}
