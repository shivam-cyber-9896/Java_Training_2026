package com.shivam.monocept.Inventory.model1.ValuationStrategy;



import java.util.List;
import com.shivam.monocept.Inventory.model1.product.Product;

public class LIFOValuation implements ValuationStrategy {

    @Override
    public double calculateValue(List<Product> products) {

        double total = 0;

        for (int i = products.size() - 1; i >= 0; i--) {
            Product product = products.get(i);
            total += product.getPrice() * product.getQuantity();
        }

        System.out.println("Calculating inventory value using LIFO...");
        return total;
    }
}