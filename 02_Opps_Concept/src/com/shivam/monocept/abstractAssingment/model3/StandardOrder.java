package com.shivam.monocept.abstractAssingment.model3;


public class StandardOrder extends Order {

    private static long orderId =3033;

	public StandardOrder(String customerName, String productName, int quantity, double pricePerUnit) {
        super(++orderId , customerName, productName, quantity, pricePerUnit);
       
    }

    @Override
    public void processOrder() {
        System.out.println("Processing Standard Order with normal delivery.");
    }
}