package com.shivam.monocept.Inventory.model1.Inventoryservices;

import java.util.List;
import java.util.Optional;

import com.shivam.monocept.Inventory.model1.Notifier.Email;
import com.shivam.monocept.Inventory.model1.Notifier.Sms;
import com.shivam.monocept.Inventory.model1.ValuationStrategy.FIFOValuation;
import com.shivam.monocept.Inventory.model1.product.Product;
import com.shivam.monocept.Inventory.model1.reorderservice.Reorder;

public class TrigerReorder {
	Reorder order=new Reorder();
	Email email=new Email();
	Sms sms=new Sms();
	 FIFOValuation fifocal=new FIFOValuation();
void reOrder(List<Product> products){
	List<Product> lessQuantity=products.stream()
	.filter(p->p.getQuantity()<=p.getReOrderLimit())
	.toList();
	for(Product p:lessQuantity) {
		email.notifaction(p);
		sms.notifaction(p);
		order.Apply(p);
		email.notifaction(p);
		sms.notifaction(p);
	}
	   System.out.println("Total Inventory Value Using FIFo   "+fifocal.calculateValue(products));
}
}
