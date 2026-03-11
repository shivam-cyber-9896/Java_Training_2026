package com.shivam.monocept.interfacelearning.model3.test;


import java.util.Scanner;
import com.shivam.monocept.interfacelearning.model3.*;

public class AccountTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountOperation account = null;

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Create Loan Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Check Balance");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String sName = sc.nextLine();
                    while(sName==null || sName.trim().isEmpty()||!sName.trim().matches("^[A-Za-z]{2,}\\s[A-Za-z]{2,}$"))
                    {
                    	System.out.print("Enter Name: ");
                        sName = sc.nextLine();
                    	
                    }
                    System.out.print("Enter Initial Balance: ");
                    String sBalance = sc.nextLine();
                    while (sBalance == null ||
                    	       sBalance.trim().isEmpty() ||
                    	       !sBalance.trim().matches("^(0|[1-9][0-9]*)(\\.[0-9]{1,2})?$")) {
                    	System.out.print("Enter Initial Balance: ");
                        sBalance = sc.nextLine();
                    }
                    account = new SavingsAccount(sName, sBalance);
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String cName = sc.nextLine();
                    while(cName==null|| cName.trim().isEmpty()||!cName.trim().matches("^[A-Za-z]{2,}\\s[A-Za-z]{2,}$"))
                    {
                    	System.out.print("Enter Name: ");
                        cName = sc.nextLine();
                    	
                    }
                    System.out.print("Enter Balance: ");
                    String cBalance = sc.nextLine();
                    while (cBalance == null ||
                    	       cBalance.trim().isEmpty() ||
                    	       !cBalance.trim().matches("^(0|[1-9][0-9]*)(\\.[0-9]{1,2})?$")) {
                    	System.out.print("Enter Initial Balance vaild: ");
                        cBalance = sc.nextLine();
                    }
                    System.out.print("Enter Overdraft Limit: ");
                    String odLimit = sc.nextLine();
                    while (odLimit == null ||
                    		odLimit.trim().isEmpty() ||
                 	       !odLimit.trim().matches("^(0|[1-9][0-9]*)(\\.[0-9]{1,2})?$")) {
                 	System.out.print("Enter Initial Balance vaild: ");
                 	odLimit = sc.nextLine();
                 }
                    account = new CurrentAccount(cName, cBalance, odLimit);
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String lName = sc.nextLine();
                    while(lName==null|| lName.trim().isEmpty()||!lName.trim().matches("^[A-Za-z]{2,}\\s[A-Za-z]{2,}$"))
                    {
                    	System.out.print("Enter Name: ");
                        lName = sc.nextLine();
                    	
                    }
                    System.out.print("Enter Loan Amount: ");
                    String loanAmt = sc.nextLine();
                    while (loanAmt == null ||
                    		loanAmt.trim().isEmpty() ||
                    	       !loanAmt.trim().matches("^(0|[1-9][0-9]*)(\\.[0-9]{1,2})?$"))
                    {
                    	System.out.print("Enter Initial Balance: ");
                        loanAmt = sc.nextLine();
                    }
                    System.out.print("Enter Annual Interest %: ");
                    double rate = sc.nextDouble();
                    while(rate<=0) {
                    	System.out.print("Enter vaild Annual Interest %: ");
                            rate = sc.nextDouble();
                    }
                    System.out.print("Enter Years: ");
                    double year = sc.nextDouble();
                    while(year<=0) {
                    	System.out.print("Enter Years: ");
                         year = sc.nextDouble();
                    }
                    sc.nextLine();
                    account = new LoanAccount(lName, loanAmt, rate, year);
                    break;

                case 4:
                    if (account != null) {
                        System.out.print("Enter Deposit Amount: ");
                        String dep = sc.nextLine();
                        account.deposit(dep);
                    } else {
                        System.out.println("Create Account First!");
                    }
                    break;

                case 5:
                    if (account != null) {
                        System.out.print("Enter Withdraw Amount: ");
                        String wd = sc.nextLine();
                        account.withDrow(wd);
                    } else {
                        System.out.println("Create Account First!");
                    }
                    break;

                case 6:
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Create Account First!");
                    }
                    break;

                case 7:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}