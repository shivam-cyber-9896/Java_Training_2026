package com.shivam.monocept.order.model1;

public class PriorityOrder extends Order {

	@Override
	public String toString() {
		return "PriorityOrder [orderId  "+ orderId+"customerName=" + customerName + ", TotalAmount=" + TotalAmount + ", quantity=" + quantity
				+ "]";
	}

	public PriorityOrder(long orderId,String customerName, double totalAmount, int quantity) {
		super(orderId, customerName, totalAmount, quantity);
		
	}

}
