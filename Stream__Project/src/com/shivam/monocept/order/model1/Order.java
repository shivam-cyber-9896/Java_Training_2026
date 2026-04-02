package com.shivam.monocept.order.model1;



public class Order {

    private int orderId;
    private String customerName;
    private String category;
    private double amount;
   

    private OrderStatus status;

    public Order(int orderId, String customerName, String category, double amount, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.category = category;
        this.amount = amount;
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

   
   
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return "Order{" +
                "ID=" + orderId +
                ", Name='" + customerName + '\'' +
                ", Category='" + category + '\'' +
                ", Amount=" + amount +
                ", Status='" + status + '\'' +
                '}';
    }
}
