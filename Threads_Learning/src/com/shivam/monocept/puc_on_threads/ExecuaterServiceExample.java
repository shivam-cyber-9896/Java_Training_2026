package com.shivam.monocept.puc_on_threads;
import java.util.concurrent.*;

public class ExecuaterServiceExample {
    public static void main(String[] args) {
        
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            
            for(int i = 1; i <= 5; i++) {
                int num = i;
                executor.submit(() -> {
                    System.out.println("Task " + num);
                });
            }
        }
    }
}