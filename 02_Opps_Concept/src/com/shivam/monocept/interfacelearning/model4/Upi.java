package com.shivam.monocept.interfacelearning.model4;


public class Upi implements PaymentGateway {

    private String upiId;

    public Upi(String upiId) {
        this.upiId = upiId;
    }
    
    @Override
    public void pay(double Amount) {
        System.out.println("Processing UPI Payment...");
        System.out.println("Amount ₹" + Amount + " paid using UPI ID: " + upiId);
    }
    @Override
    public void refund(double Amount) {
        System.out.println("Refunding ₹" + Amount + " to UPI ID: " + upiId);
    }
}