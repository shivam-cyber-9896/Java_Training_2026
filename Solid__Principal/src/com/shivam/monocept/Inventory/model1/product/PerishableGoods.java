package com.shivam.monocept.Inventory.model1.product;

import java.time.LocalDate;

public class PerishableGoods extends Product {

    private LocalDate expiryDate;

    public PerishableGoods(String name, double price, int quantity, LocalDate expiryDate,int reOrderLimit) {
        super(name, price, quantity, "PERISHABLE",reOrderLimit);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

	@Override
	public String toString() {
		return " PerishableGoods "+super.toString()+"[expiryDate=" + expiryDate + "]";
	}
    
}