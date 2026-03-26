package com.shivam.monocept.producerconsumer.model1;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer full, producer waiting...");
            wait();
        }

        buffer.add(item);
        System.out.println("Produced: " + item);

        notifyAll(); // better than notify()
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty, consumer waiting...");
            wait();
        }

        int item = buffer.poll();
        System.out.println("Consumed: " + item);

        notifyAll(); 
        return item;
    }
}