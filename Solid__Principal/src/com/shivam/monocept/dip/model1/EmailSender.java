package com.shivam.monocept.dip.model1;

public class EmailSender implements Notifier {
    public void send(String message) {
        System.out.println(" Email sent: " + message);
    }
}
