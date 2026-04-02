package com.shivam.monocept.Inventory.model1.product;

public abstract class Product {

private	String name;
	private double price;
private	int quantity;
private int reOrderLimit;
	String type;
	public Product(String name, double price,int quantity,String type,int reOrderLimit) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.type=type;
		this.reOrderLimit=reOrderLimit;
	}
	public int getReOrderLimit() {
		return reOrderLimit;
	}
	public void setReOrderLimit(int reOrderLimit) {
		this.reOrderLimit = reOrderLimit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", price=" + price + ", quantity=" + quantity + ", reOrderLimit="
				+ reOrderLimit + ", type=" + type + "]";
	}
	public String getType() {
		return type;
	}
}
