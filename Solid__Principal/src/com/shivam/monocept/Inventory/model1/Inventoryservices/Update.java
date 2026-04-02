package com.shivam.monocept.Inventory.model1.Inventoryservices;

import java.util.List;
import java.util.Optional;

import com.shivam.monocept.Inventory.model1.product.Product;

public class Update {
	public void updateProduct(List<Product> products, String name, double price, int quantity) {

	    products.stream()
	            .filter(p -> p.getName().equalsIgnoreCase(name))
	            .forEach(p -> {
	                p.setPrice(price);
	                p.setQuantity(quantity);
	            });
	}
}
