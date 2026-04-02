package com.shivam.monocept.dip.model1;

public class WhatsAppNotifier implements Notifier {
    public void send(String message) {
        System.out.println(" WhatsApp message: " + message);
    }
}