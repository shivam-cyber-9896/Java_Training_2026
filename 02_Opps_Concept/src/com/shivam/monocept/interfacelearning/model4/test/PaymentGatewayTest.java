package com.shivam.monocept.interfacelearning.model4.test;

import java.util.Scanner;

import com.shivam.monocept.interfacelearning.model4.*;


public class PaymentGatewayTest {
	

	public static void main(String[] argus) {
	 Scanner sc = new Scanner(System.in);
     Checkout checkout = null;
     PaymentGateway Payment=null;
     int  choice;

     do {
         System.out.println("\n===== E-Commerce Checkout System =====");
         System.out.println("1. Select Payment Method");
         System.out.println("2. Make Payment");
         System.out.println("3. Refund Payment");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");

        choice = sc.nextInt();

         switch (choice) {

             case 1:
                 System.out.println("\nChoose Payment Method:");
                 System.out.println("1. Credit Card");
                 System.out.println("2. UPI");
                 System.out.println("3. NetBanking");

                 int method = sc.nextInt();
                 sc.nextLine(); 

                 switch (method) {
                     case 1:
                         System.out.print("Enter Card Number: ");
                         String cardNumber = sc.nextLine();
                         while (cardNumber == null ||
                        	       cardNumber.trim().isEmpty() ||
                        	       !cardNumber.trim().matches("^(\\d{4}[- ]?){3}\\d{4}$")) {

                        	    System.out.print("Enter Credit Card Number: ");
                        	    cardNumber = sc.nextLine();
                        	}
                         Payment =new CreditCard(cardNumber);
                         System.out.println("Credit Card selected.");
                         break;

                     case 2:
                         System.out.print("Enter UPI ID: ");
                         String upiId = sc.nextLine();
                         while (upiId == null ||
                        	       upiId.trim().isEmpty() ||
                        	       !upiId.trim().matches("^[a-zA-Z0-9._]{3,}@[a-zA-Z]{2,}$")) {

                        	    System.out.print("Enter UPI ID: ");
                        	    upiId = sc.nextLine();
                        	}
                          Payment= new Upi(upiId);
                         System.out.println("UPI selected.");
                         break;

                     case 3:
                         System.out.print("Enter Bank Name: ");
                         String bankName = sc.nextLine();
                         while (bankName == null ||
                        	       bankName.trim().isEmpty() ||
                        	       !bankName.trim().matches("^[A-Za-z]{2,}(\\s[A-Za-z]{2,})*$")) {

                        	    System.out.print("Enter Bank Name: ");
                        	    bankName = sc.nextLine();
                        	}
                        Payment=new NetBanking(bankName);
                         System.out.println("NetBanking selected.");
                         break;

                     default:
                         System.out.println("Invalid Payment Method.");
                 }
                 break;

             case 2:
            	 checkout= new Checkout(Payment);
            	 if(Payment==null) {
            		 break;
            	 }
            	
                 System.out.print("Enter Amount to Pay: ");
                 double payAmount = sc.nextDouble();
                 while(payAmount<=0) {
                	 System.out.print("Enter Amount to Pay: ");
                    payAmount = sc.nextDouble();
                 }
                 
                    checkout.completePayment(payAmount);    
                 break;

             case 3:
            	 checkout= new Checkout(Payment);
            	 if(Payment==null) {
            		 break;
            	 }
            	
                 System.out.print("Enter Amount to Refund: ");
                 double refundAmount = sc.nextDouble();
                 while(refundAmount<=0) {
                	 System.out.print("Enter Amount to Refund: ");
                      refundAmount = sc.nextDouble();
                 }
                 checkout.initiateRefund(refundAmount);
                 break;

             case 4:
                 System.out.println("Thank you for using E-Commerce System.");
                 break;

             default:
                 System.out.println("Invalid choice.");
         }

     } while (choice != 4);

     sc.close();
 }
}


