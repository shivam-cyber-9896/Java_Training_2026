package com.shivam.monocept.constructor.model1;


public class DiscountedOrder extends Order {

    private final double discountPercentage;

    public DiscountedOrder(Product product,
                           int quantity,
                           double discountPercentage) {

        super(product, quantity);  

        this.discountPercentage = discountPercentage;

        // Apply discount
        this.totalAmount = totalAmount -
                (totalAmount * discountPercentage / 100);
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
