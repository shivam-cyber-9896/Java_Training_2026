package com.shivam.monocept.abstractAssingment.model3;

public abstract class Order implements OrderVerification {

    protected long orderId;
    protected String customerName;
    protected int quantity;
    protected double pricePerUnit;
    protected double totalPrice;
    protected String productName;
    static {
        System.out.println("Welcome To order Delivering System");
    }

    public Order(long orderId, String customerName,String productName,int quantity, double pricePerUnit) {
       
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public void verifyOrder() throws InvalidOrderException {

        if (customerName == null || customerName.isEmpty()) {
            throw new InvalidOrderException("Customer name cannot be empty");
        }

        if (quantity <= 0)
            throw new InvalidOrderException("Quantity must be positive");

        if (pricePerUnit <= 0)
            throw new InvalidOrderException("Price must be positive");
    }
    public void displayOrder() {
        System.out.println("Order ID : " + orderId);
        System.out.println("Customer : " + customerName);
        System.out.println("Product  : " + productName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price Per Unit: "+pricePerUnit);
        totalPrice=quantity*pricePerUnit;
        System.out.println("Total Price : " + totalPrice);
    }
    public abstract void processOrder();
}