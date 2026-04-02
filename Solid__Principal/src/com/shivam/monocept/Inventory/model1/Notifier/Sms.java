package com.shivam.monocept.Inventory.model1.Notifier;

import com.shivam.monocept.Inventory.model1.product.Product;

public class Sms implements Notifier{

	@Override
	public void notifaction(Product p) {
		
		if(p.getQuantity()<=p.getReOrderLimit())
		{
			System.out.println(" [ Sms ]Low stock alert for "+p.getName());
			
			return;
		}
		System.out.println(" [ Sms ] stock alert for "+p.getName()+" "+p.getQuantity());
	}

}
