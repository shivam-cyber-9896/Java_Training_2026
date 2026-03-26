package com.shivam.monocept.order.model1;

public abstract class Order {

	

	protected  long orderId;
	
	protected String customerName;
	protected double TotalAmount;
	protected int quantity;

	public Order( long orderId,String customerName, double totalAmount, int quantity) {
		this.orderId = orderId;
		this.customerName = customerName;
		TotalAmount = totalAmount;
		this.quantity = quantity;
	}

	public  long getOrderId() {
		return orderId;
	}

	

	public String getCustomerName() {
		return customerName;
	}

	
	public double getTotalAmount() {
		return TotalAmount;
	}


	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Order [orderId"+orderId      +"customerName=" + customerName + ", TotalAmount=" + TotalAmount + ", quantity=" + quantity + "]";
	}

	
}
