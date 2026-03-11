package com.shivam.monocept.encapsulation.test;
import java.util.Scanner;

import com.shivam.monocept.encapsulation.model1.InsuranceClaim;

public class UserOfInsuranceClaim {

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

        // Create Claim
        System.out.print("Enter Policy Number: ");
        String policyNumber = sc.nextLine();

        System.out.print("Enter Claim Amount: ");
        double claimAmount = sc.nextDouble();
        if(policyNumber==null||policyNumber.trim().isBlank()) {
        	  // Create Claim
            System.out.print("Enter Policy Number: ");
             policyNumber = sc.nextLine();

        }
        if(claimAmount<=0) {
        	claimAmount = sc.nextDouble();
        }

        InsuranceClaim claim = new InsuranceClaim(policyNumber, claimAmount);

        int choice;

        do {
            System.out.println("\n===== INSURANCE CLAIM MENU =====");
            System.out.println("1. View Claim Details");
            System.out.println("2. Approve Claim");
            System.out.println("3. Reject Claim");
            System.out.println("4. Settle Claim");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Claim Details ---");
                    System.out.println("Claim ID: " + claim.getClaimId());
                    System.out.println("Status: " + claim.getClaimStatus());
                    System.out.println("Approved Amount: " + claim.getApprovedAmount());
                    break;

                case 2:
                    System.out.print("Enter amount to approve: ");
                    double approveAmount = sc.nextDouble();
                    claim.approveClaim(approveAmount);
                    break;

                case 3:
                    claim.rejectClaim();
                    break;

                case 4:
                    claim.settleClaim();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
        

    }
}
