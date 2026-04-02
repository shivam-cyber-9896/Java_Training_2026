package com.shivam.monocept.Inventory.model1.Notifier;

import com.shivam.monocept.Inventory.model1.product.Product;

public class Email implements Notifier {
	public void notifaction(Product p) {
		
		if(p.getQuantity()<=p.getReOrderLimit())
		{
			System.out.println(" [ Email ]Low stock alert for "+p.getName());
			return;
		}
		System.out.println(" [ Email ] stock alert for "+p.getName()+" "+p.getQuantity());
	}
}
