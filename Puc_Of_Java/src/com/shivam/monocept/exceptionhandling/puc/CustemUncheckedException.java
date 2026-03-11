package com.shivam.monocept.exceptionhandling.puc;

class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String message) {
        super(message);
    }
}
public class CustemUncheckedException {
	static void withdraw(double amount) {

        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be positive.");
        }

        System.out.println("Withdrawal successful."+amount);
    }

    public static void main(String[] args) {
        withdraw(500);  
        withdraw(-500);   
        System.out.println("Program continues...");
    }
}                                                                                       
