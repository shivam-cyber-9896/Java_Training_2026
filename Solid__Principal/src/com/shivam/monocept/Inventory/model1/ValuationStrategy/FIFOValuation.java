package com.shivam.monocept.Inventory.model1.ValuationStrategy;

import java.util.List;
import com.shivam.monocept.Inventory.model1.product.Product;

public class FIFOValuation implements ValuationStrategy {

    @Override
    public double calculateValue(List<Product> products) {

    	double total = products.stream()
    	        .mapToDouble(p -> p.getPrice() * p.getQuantity())
    	        .sum();
      
        System.out.println("Calculating inventory value using FIFO...");
        return total;
    }
}