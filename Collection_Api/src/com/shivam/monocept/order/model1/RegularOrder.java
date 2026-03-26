package com.shivam.monocept.order.model1;

public class RegularOrder extends Order {

	public RegularOrder(long orderId,String customerName, double totalAmount, int quantity) {
		super(orderId, customerName, totalAmount, quantity);
		
	}

	@Override
	public String toString() {
		return "RegularOrder [orderId"+orderId+"customerName=" + customerName + ", TotalAmount=" + TotalAmount + ", quantity=" + quantity
				+ "]";
	}

}
