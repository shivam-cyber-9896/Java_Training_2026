package com.shivam.monocept.interfacelearning.model4;

public class CreditCard implements PaymentGateway {

    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Amount ₹" + amount + " paid using Card: " + cardNumber);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding ₹" + amount + " to Credit Card: " + cardNumber);
    }
}