package com.shivam.monocept.Inventory.model1.ValuationStrategy;


import java.util.List;
import com.shivam.monocept.Inventory.model1.product.Product;

public interface ValuationStrategy {

    double calculateValue(List<Product> products);
}