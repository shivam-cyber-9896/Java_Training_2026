package com.shivam.monocept.Inventory.model1.controller;

import java.util.List;
import java.util.Scanner;

import com.shivam.monocept.Inventory.model1.Inventoryservices.Add;
import com.shivam.monocept.Inventory.model1.Inventoryservices.Remove;
import com.shivam.monocept.Inventory.model1.Inventoryservices.Update;
import com.shivam.monocept.Inventory.model1.ValuationStrategy.FIFOValuation;
import com.shivam.monocept.Inventory.model1.ValuationStrategy.LIFOValuation;
import com.shivam.monocept.Inventory.model1.product.Product;

public class Menu {

    public static  void Start() {

        Scanner scanner = new Scanner(System.in);

        List<Product> products = Input.getList();

        Add addService = new Add();
        Remove removeService = new Remove();
        Update updateService = new Update();
        FIFOValuation fifocal=new FIFOValuation();
        LIFOValuation lifocal=new LIFOValuation();
        while (true) {

            System.out.println("\n========= INVENTORY MENU =========");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Add Quantity");
            System.out.println("5. Remove Quantity");
            System.out.println("6. View Products");
            System.out.println("7.Fifo Valuation ");
            System.out.println("8. Lifo Valuation");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            String choice2 = scanner.nextLine();
            int choice=0;
           if(choice2.matches("[1-9]"))
      choice =Integer.parseInt(choice2);
     switch (choice) {

                case 1:
                    System.out.println("1. Perishable");
                    System.out.println("2. Non-Perishable");
                    String typeChoice = scanner.nextLine();
                      if(typeChoice.matches("[1,2]")) {
                    if (typeChoice.equals("1")) {
                        Input.input("PERISHABLE");
                        break;
                    } 
                   
                        Input.input("NON_PERISHABLE");
                        break;
                     }
                        System.out.println(" Invalid type!");
              
                    break;

                case 2:
                    System.out.print("Enter product name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    removeService.removeProduct(products, nameToRemove);
                    break;

                case 3:
                	System.out.print("Enter product name to update: ");
                	String name = scanner.nextLine();

                	while (name == null || name.trim().isEmpty() || !name.matches("^[A-Za-z ]{2,}$")) {
                	    System.out.print("Invalid name! Enter again: ");
                	    name = scanner.nextLine();
                	}

                	
                	System.out.print("Enter new price: ");
                	String priceInput = scanner.nextLine();

                	while (priceInput == null || priceInput.trim().isEmpty() || !priceInput.matches("^\\d+(\\.\\d{1,2})?$")) {
                	    System.out.print("Invalid price! Enter again: ");
                	    priceInput = scanner.nextLine();
                	}
                	double price = Double.parseDouble(priceInput);

                	
                	System.out.print("Enter new quantity: ");
                	String qtyInput = scanner.nextLine();

                	while (qtyInput == null || qtyInput.trim().isEmpty() || !qtyInput.matches("^\\d+")) {
                	    System.out.print("Invalid quantity! Enter again: ");
                	    qtyInput = scanner.nextLine();
                	}
                	int qty = Integer.parseInt(qtyInput);

                	
                	updateService.updateProduct(products, name, price, qty);
                	break;
                case 4:
                    System.out.print("Enter product name: ");
                    String addName = scanner.nextLine();
                    while (addName == null || addName.trim().isEmpty() || !addName.matches("^[A-Za-z ]{2,}$")) {
                	    System.out.print("Invalid name! Enter again: ");
                	    addName = scanner.nextLine();
                	}
                    Product addProduct = findProduct(products, addName);

                    if (addProduct != null) {
                        System.out.print("Enter quantity to add: ");
                        int q = Integer.parseInt(scanner.nextLine());
                        addService.addQuatity(addProduct, q);
                        break;
                    } 
                        System.out.println("Product not found!");
                    
                    break;

                case 5:
                    System.out.print("Enter product name: ");
                    String removeName = scanner.nextLine();
                    while (removeName == null || removeName.trim().isEmpty() || !removeName.matches("^[A-Za-z ]{2,}$")) {
                	    System.out.print("Invalid name! Enter again: ");
                	    removeName = scanner.nextLine();
                	}
                    Product removeProduct = findProduct(products, removeName);

                    if (removeProduct != null) {
                        System.out.print("Enter quantity to remove: ");
                        int q = Integer.parseInt(scanner.nextLine());
                        removeService.removeQuantity(removeProduct, q, products);
                        break;
                    } 
                        System.out.println("Product not found!");
                    
                    break;

                case 6:
                    products.stream()
                    .forEach(System.out::println);
                    break;
                case 7:
                      System.out.println("Total Inventory Value Using FIFo   "+fifocal.calculateValue(products));     
                	break;
                case 8:
                	System.out.println("Total Inventory Value Using FIFo   "+lifocal.calculateValue(products));
                	break;
                case 9:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }

   
    private static Product findProduct(List<Product> products, String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    
    }
