package com.shivam.monocept.interfacelearning.model1;



public class UpiPayment implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment of ₹" + amount);
        System.out.println("UPI Payment Successful!");
    }
}