package com.shivam.monocept.constructor.model1;



public class Product {

    private static int counter = 1000;

    private final int productId;
    private final double price;
    private int stockQuantity;

    
    public Product(double price, int stockQuantity) {

        

        this.productId = ++counter;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

   
    public Product(double price) {
        this(price, 0);   
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
