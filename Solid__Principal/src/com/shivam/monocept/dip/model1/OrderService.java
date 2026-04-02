package com.shivam.monocept.dip.model1;

 import java.util.List;

public class OrderService {

    private List<Notifier> notifiers;

    
    public OrderService(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void placeOrder(String message) {
        System.out.println("Order placed!");

        for (Notifier notifier : notifiers) {
            notifier.send(message);
        }
    }
}