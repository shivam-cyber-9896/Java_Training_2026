package com.shivam.monocept.abstractAssingment.model3;


public class ExpressOrder extends Order {

    private static long orderId=69601;

	public ExpressOrder( String customerName, String productName, int quantity, double pricePerUnit) {
        super(++orderId, customerName, productName, quantity, pricePerUnit);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing Express Order with fast delivery.");
    }
}