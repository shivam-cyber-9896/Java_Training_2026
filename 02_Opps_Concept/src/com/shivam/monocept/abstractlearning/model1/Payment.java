package com.shivam.monocept.abstractlearning.model1;

public abstract class Payment {
	private String Amount;
	Payment(String Amount){
		this.Amount=Amount;
	}
	public boolean validateAmount(String Amount) {
		double amount=Double.parseDouble(Amount.trim());
	
       if (amount > 0) {
            return true;
        } 
            return false;
        
    }

    public abstract void processPayment();

   
    public abstract void generateReceipt(); 
}
