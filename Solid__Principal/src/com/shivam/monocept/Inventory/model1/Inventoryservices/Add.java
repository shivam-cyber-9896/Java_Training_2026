package com.shivam.monocept.Inventory.model1.Inventoryservices;

import java.util.List;

import com.shivam.monocept.Inventory.model1.product.Product;

public class Add {

	void add(List<Product> products, Product product) {
		products.add(product);
		System.out.println("Product added: " + product.getName());

	}
	public void addQuatity(Product p,int i) {
		int c=p.getQuantity()+i;
		System.out.println("Updated Product"+p.getName()+" Stock Quantity"+c);
	}
}
