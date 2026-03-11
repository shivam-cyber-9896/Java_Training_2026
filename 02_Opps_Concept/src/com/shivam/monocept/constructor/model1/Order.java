package com.shivam.monocept.constructor.model1;


public class Order {

    private static int counter = 5000;

    private final int orderId;
    private final Product product;
    private final int quantity;
    protected double totalAmount;

    public Order(Product product, int quantity) {

      
        this.orderId = ++counter;
        this.product = product;
        this.quantity = quantity;

        // Calculate total immediately
        this.totalAmount = product.getPrice() * quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Product getProduct() {
        return product;
    }

	
}
