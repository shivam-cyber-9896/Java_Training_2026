package com.shivam.monocept.abstractAssingment.model3;


public class InternationalOrder extends Order {

    private static long orderId=5050;

	public InternationalOrder(String customerName, String productName, int quantity, double pricePerUnit) {
        super(++orderId, customerName, productName, quantity, pricePerUnit);
       
    }

    @Override
    public void processOrder() {
        System.out.println("Processing International Order with customs verification.");
    }
}