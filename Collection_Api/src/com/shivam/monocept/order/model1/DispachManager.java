package com.shivam.monocept.order.model1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DispachManager  {
	 private List<Order> order = new ArrayList<>();
	    private Queue<Order> dispatchQueue = new LinkedList<>();
	    
 public void addOrder( Order or)
 {
	order.add(or); 
	dispatchQueue.offer(or);
	removeDuplicateOrder();
 }
 public void dispachOrder()
 {
	 if(dispatchQueue.isEmpty())
		 {System.out.println("noithing to dispach");
		 return;}
	 Order done=dispatchQueue.poll();
	 System.out.println("Dispached Order"+done);
 }
 
 
 public void removeDuplicateOrder() {

     Iterator<Order> remove=order.iterator();
     Set<Long> seenIds = new HashSet<>();
     while (remove.hasNext()) {
         Order o = remove.next();
         if (!seenIds.add(o.getOrderId())) {
        	 System.out.println("Dudlicate order Id is found we are removeing it");
        	 System.out.println("Deatail of removed order"+o);
        	 remove.remove(); 
         }
     }    
  
         }
 
 public void removeDuplicateOrderById(Long id) {

     Iterator<Order> remove=order.iterator();
     
     while (remove.hasNext()) {
         Order o = remove.next();
         if (o.getOrderId()==id) {
        	 System.out.println("order removed "+o);
        	 remove.remove(); 
        	 return;
         }
         System.out.println(id+"Given id is invaild");
     }    
    
         }   
 public void DisplayOrder() {
	for(Order o:order) 
	{
		System.out.println(o);
	}
 }
 
 public void sortById() {
	    order.sort(Comparator.comparingLong(Order::getOrderId));
	    DisplayOrder();
	} 
 public  void sortByAmount() {
	 order.sort(Comparator.comparingDouble(Order::getTotalAmount));
	}
 public void sortByName() {

	    Collections.sort(order, new Comparator<Order>() {

	        @Override
	        public int compare(Order o1, Order o2) {
	            return o1.getCustomerName().compareTo(o2.getCustomerName());
	        }
	    });
	}
}
