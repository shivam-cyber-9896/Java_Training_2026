package com.shivam.monocept.interfacelearning.model4;


public class NetBanking implements PaymentGateway {

    private String bankName;

    public NetBanking(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Net Banking Payment...");
        System.out.println("Amount ₹" + amount + " paid via Bank: " + bankName);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding ₹" + amount + " to Bank: " + bankName);
    }
}