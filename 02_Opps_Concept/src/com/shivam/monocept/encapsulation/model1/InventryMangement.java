package com.shivam.monocept.encapsulation.model1;

public class InventryMangement {

    private static long counter = 1000;

    private final long productId;
    private String productName;
    private double price;
    private int stockQuantity;
    private boolean discontinued;

    public InventryMangement(String productName, double price, int initialStock) {

        if (productName == null || productName.trim().isEmpty()) {
            System.out.println("Product name cannot be empty.");
            productName = "Unknown Product";
        }

        if (price < 0) {
            System.out.println("Price cannot be negative. Setting to 0.");
            price = 0;
        }

        if (initialStock < 0) {
            System.out.println("Stock cannot be negative. Setting to 0.");
            initialStock = 0;
        }

        this.productId = ++counter;
        this.productName = productName;
        this.price = price;
        this.stockQuantity = initialStock;
        this.discontinued = false;
    }

    // Getters
    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    // Increase stock
    public void increaseStock(int quantity) {

        if (discontinued) {
            System.out.println("Product is discontinued. Cannot increase stock.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Increase quantity must be positive.");
            return;
        }

        stockQuantity += quantity;
        System.out.println("Stock increased successfully!");
    }

    // Reduce stock
    public void reduceStock(int quantity) {

        if (discontinued) {
            System.out.println("Product is discontinued. Cannot reduce stock.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Reduction quantity must be positive.");
            return;
        }

        if (quantity > stockQuantity) {
            System.out.println("Insufficient stock.");
            return;
        }

        stockQuantity -= quantity;
        System.out.println("Stock reduced successfully!");
    }

    // Update price
    public void updatePrice(double newPrice) {

        if (newPrice < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        this.price = newPrice;
        System.out.println("Price updated successfully!");
    }

    // Discontinue product
    public void discontinueProduct() {
        this.discontinued = true;
        System.out.println("Product discontinued successfully!");
    }
}

