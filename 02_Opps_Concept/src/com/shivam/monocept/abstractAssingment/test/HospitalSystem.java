package com.shivam.monocept.abstractAssingment.test;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.abstractAssingment.model2.*;

public class HospitalSystem {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter number of services to create:");
            int n = scanner.nextInt();

            while (n <= 0) {
                System.out.println("Enter valid number:");
                n = scanner.nextInt();
            }

            HospitalService[] service = new HospitalService[n];

            int choice;
            int index = 0;

            do {

                System.out.println("\n1.General Consultation");
                System.out.println("2.Surgery");
                System.out.println("3.Diagnostic Test");
                System.out.println("4.Display Services");
                System.out.println("5.Calculate Fee");
                System.out.println("6.Exit");

                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    while (name == null || name.trim().isEmpty() || !name.matches("^[A-Za-z]+$")) {
                        System.out.print("Enter valid name: ");
                        name = scanner.nextLine();
                    }
                    System.out.print("Enter consultation fee: ");
                    String amount=scanner.nextLine();
                    while (amount == null || amount.trim().isEmpty() || !amount.matches("^[1-9]\\d*$")) {
                        System.out.print("Enter valid consultation fee:  ");
                        amount = scanner.nextLine();
                    }
                    double fee = Double.parseDouble(amount);
                      
                    if (choice == 1) {
                        service[index++] = new GeneralConsultation(name, fee);
                    break;}
                    System.out.println("Enter other Requaired charges");
                    String amount2=scanner.nextLine();
                    while (amount2 == null || amount2.trim().isEmpty() || !amount2.matches("^[1-9]\\d*$")) {
                        System.out.print("Enter valid consultation fee:  ");
                        amount2 = scanner.nextLine();
                    }
                    double fee2 = Double.parseDouble(amount2);
                     if (choice == 2) {
                        service[index++] = new Surgery(name, fee,fee2);
                        break;}
                    
                        service[index++] = new DiagnosticTest(name, fee,fee2);

                    break;

                case 4:

                    for (int i = 0; i < index; i++) {
                        service[i].displayDetails();
                        System.out.println("________________-_-_");
                    }

                    break;

                case 5:
                    double total = service[index-1].calculateTotalFee();

                    System.out.println("Total Fee: " + total);

                    break;
                }

            } while (choice != 6);
        }

        catch (InvalidServiceException e) {
            System.out.println(e.getMessage());
        }

        catch (InputMismatchException e) {
            System.out.println("Invalid input type");
        }

        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}