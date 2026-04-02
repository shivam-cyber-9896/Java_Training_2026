package com.shivam.monocept.dip.model1;

public class SMSSender implements Notifier {
    public void send(String message) {
        System.out.println("📱 SMS sent: " + message);
    }
}
