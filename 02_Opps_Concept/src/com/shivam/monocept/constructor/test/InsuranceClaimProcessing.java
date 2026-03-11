package com.shivam.monocept.constructor.test;

import java.util.Scanner;
import com.shivam.monocept.constructor.model1.CorporateClaim;
import com.shivam.monocept.constructor.model1.InsuranceClaim;

public class InsuranceClaimProcessing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InsuranceClaim claim = null;   // Only ONE claim
        int choice;

        do {
            System.out.println("\n====== Insurance Claim System ======");
            System.out.println("1. Create Normal Claim");
            System.out.println("2. Create Corporate Claim");
            System.out.println("3. Approve Claim");
            System.out.println("4. Reject Claim");
            System.out.println("5. View Claim");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Policy Number: ");
                    String policy = scanner.next();

                    System.out.print("Enter Claim Amount: ");
                    double amount = scanner.nextDouble();

                    claim = new InsuranceClaim(policy, amount);

                    System.out.println("Normal Claim Created Successfully!");
                    break;

                case 2:
                	String corpPolicy;
                	double corpAmount;
                	if(claim.getPolicyNumber()==null||claim.getPolicyNumber().trim().isEmpty()) {
                    System.out.print("Enter Policy Number: ");
                     corpPolicy = scanner.next();

                    System.out.print("Enter Claim Amount: ");
                     corpAmount = scanner.nextDouble();
                	}
                	else {
                		System.out.println("you are converting you claim to corparte claim so processing feess is applicable");
                	}
                	corpPolicy=claim.getPolicyNumber();
                	corpAmount=claim.getClaimAmount();
                    System.out.print("Enter Processing Fee: ");
                    double fee = scanner.nextDouble();

                    claim = new CorporateClaim(corpPolicy, corpAmount, fee);

                    System.out.println("Corporate Claim Created Successfully!");
                    break;

                case 3:
                    if (claim == null) {
                        System.out.println("No claim created yet!");
                        break;
                    }

                    claim.approveClaim(claim.getClaimAmount());
                    
                    System.out.println("Claim Approved Successfully!"+"\n Aprrved amount is  ="+claim.getApprovedAmount());
                    break;

                case 4:
                    if (claim == null) {
                        System.out.println("No claim created yet!");
                        break;
                    }

                    claim.rejectClaim();
                    System.out.println("Claim Rejected Successfully!");
                    break;

                case 5:
                    if (claim == null) {
                        System.out.println("No claim available!");
                    } else {
                        System.out.println(claim);
                    }
                    break;

                case 6:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        scanner.close();
    }
}
