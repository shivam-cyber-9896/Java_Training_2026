package com.shivam.monocept.producerconsumer.test;

import com.shivam.monocept.producerconsumer.model1.SharedBuffer;

public class SharedBufferRunner {
    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer();

       
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int value = 0;
                try {
                    while (true) {
                        buffer.produce(value++);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

       
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        buffer.consume();
                        Thread.sleep(800);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}