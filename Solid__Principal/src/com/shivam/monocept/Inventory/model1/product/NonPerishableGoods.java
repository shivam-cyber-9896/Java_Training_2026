package com.shivam.monocept.Inventory.model1.product;

public class NonPerishableGoods extends Product {

    private int warrantyMonths;

    public NonPerishableGoods(String name, double price, int quantity, int warrantyMonths,int reOrderLimit) {
        super(name, price, quantity, "NON_PERISHABLE",reOrderLimit);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
	public String toString() {
		return "NonPerishableGoods"+super.toString()+" [warrantyMonths=" + warrantyMonths + "]";
	}

	public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }
}