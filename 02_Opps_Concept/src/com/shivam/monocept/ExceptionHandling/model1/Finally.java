package com.shivam.monocept.ExceptionHandling.model1;

public class Finally {
	 private double balance=10000;
	  public void Withdrow(double balance ) {
	if(balance>this.balance) {
		  throw  new ArithmeticException("Transaction not posssible");
}
	this.balance-=balance;
	System.out.println("Amount to Be Deducted is   :"+balance);
	System.out.println("Remaing Balance Should Be "+this.balance);
	}
  
}
