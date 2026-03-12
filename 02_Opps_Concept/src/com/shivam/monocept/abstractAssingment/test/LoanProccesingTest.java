package com.shivam.monocept.abstractAssingment.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.abstractAssingment.model1.*;

public class LoanProccesingTest 
 {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Hi Welcome to Digital Loan Processing System");

            System.out.print("Total number of loans you want to create: ");
            int n = scanner.nextInt();

            while (n <= 0) {
                System.out.print("Enter valid number of loans: ");
                n = scanner.nextInt();
            }

            Loan[] loan = new Loan[n];
            int choice;
            int index = 0;

            do {

                System.out.println("\n1.Create Home Loan");
                System.out.println("2.Create Car Loan");
                System.out.println("3.Create Education Loan");
                System.out.println("4.Calculate Repayment");
                System.out.println("5.Check Eligibility");
                System.out.println("6.Display Details");
                System.out.println("7.Exit");

                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter Borrower Name: ");
                    String name = scanner.nextLine();

                    while (name == null || name.trim().isEmpty() || !name.matches("^[A-Za-z]+$")) {
                        System.out.print("Enter valid name: ");
                        name = scanner.nextLine();
                    }

                    System.out.print("Enter Loan Amount: ");
                    String amt = scanner.nextLine();

                    while (amt == null || amt.trim().isEmpty() || !amt.matches("^[1-9]\\d*$")) {
                        System.out.print("Enter valid loan amount: ");
                        amt = scanner.nextLine();
                    }

                    double amount = Double.parseDouble(amt);

                    System.out.print("Enter Interest Rate: ");
                    String rate = scanner.nextLine();

                    while (rate == null || rate.trim().isEmpty() || !rate.matches("^\\d+(\\.\\d+)?$")) {
                        System.out.print("Enter valid interest rate: ");
                        rate = scanner.nextLine();
                    }

                    double interest = Double.parseDouble(rate);
                    System.out.print("Enter years: ");
                    int years = scanner.nextInt();
                    while(years<=0|| years>20) {
                    	System.out.print("Enter years  range between 1 to 20 : ");
                        years = scanner.nextInt();
                    }
                    if (choice == 1) {
                        loan[index++] = new HomeLoan(name, amount, interest,years);
                    }

                     if (choice == 2) {
                        loan[index++] = new CarLoan(name, amount, interest,years);
                    }

                     if (choice == 3) {
                        loan[index++] = new EducationLoan(name, amount, interest,years);
                    }

                    System.out.println("Loan Created Successfully!");
                    break;

                case 4:

                    double repay = loan[index-1].calculateRepayment();

                    System.out.println("Total Repayment Amount: " + repay);
                    break;

                case 5:
                	  System.out.print("plese Enter Your salery to check you are elgigible ");
                      String salery = scanner.nextLine();

                      while (salery == null || salery.trim().isEmpty() || !salery.matches("^[1-9]\\d*$")) {
                          System.out.print("Enter valid loan amount: ");
                          salery = scanner.nextLine();
                      }

                      double saleryCheck = Double.parseDouble(salery);
                    if(loan[index-1].checkEligibility(saleryCheck))
                    {
                    	System.out.println("Egible to loan");
                    	loan[index-1].displayLoanDetails();
                    }
                    break;

                case 6:

                    for (int i = 0; i < index; i++) {
                        loan[i].displayLoanDetails();
                        System.out.println("----------------------");
                    }

                    break;

                }

            } while (choice != 7);

        }

        catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }

        catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Loan limit exceeded or invalid index");
        }

        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}

