package com.shivam.monocept.Inventory.model1.reorderservice;

import com.shivam.monocept.Inventory.model1.product.Product;

public class Reorder {
	final int Addtion=20;
public void Apply(Product p) {
	
	int c=Addtion+p.getQuantity();
	p.setQuantity(c);
	}
}
