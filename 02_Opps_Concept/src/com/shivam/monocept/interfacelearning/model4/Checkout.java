package com.shivam.monocept.interfacelearning.model4;



public class Checkout {

    private PaymentGateway paymentGateway;

    
    public  Checkout(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void completePayment(double amount) {
        paymentGateway.pay(amount);
    }

    public void initiateRefund(double amount) {
        paymentGateway.refund(amount);
    }
}