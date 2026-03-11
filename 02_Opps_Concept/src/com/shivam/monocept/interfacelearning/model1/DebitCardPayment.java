package com.shivam.monocept.interfacelearning.model1;



public class DebitCardPayment implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Debit Card Payment of ₹" + amount);
        System.out.println("Debit Card Payment Successful!");
    }
}