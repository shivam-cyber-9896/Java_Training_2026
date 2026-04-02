package com.shivam.monocept.Inventory.model1.Inventoryservices;

import java.util.List;

import com.shivam.monocept.Inventory.model1.product.Product;

public class Remove

{
	TrigerReorder order=new TrigerReorder();
	public void removeProduct(List<Product> products, String name) {

        boolean removed = products.removeIf(p -> p.getName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Product removed: " + name);
          return;
        }
        System.out.println("this product is not present"+name);
	}
	public void removeQuantity(Product p, int quantity, List<Product> products) {

	    if (p == null) {
	        System.out.println("Product not found!");
	        return;
	    }

	    if (quantity <= 0) {
	        System.out.println("Enter valid quantity!");
	        return;
	    }

	    if (quantity <= p.getQuantity()) {
	        int left = p.getQuantity() - quantity;
	        p.setQuantity(left);

	        System.out.println("Quantity removed successfully. Remaining: " + left);

	        if (order != null) { 
	            order.reOrder(products);
	            
	        }
	        return;
	    } 
	        System.out.println("Removal not possible! Not enough stock.");
	    
	}
}
