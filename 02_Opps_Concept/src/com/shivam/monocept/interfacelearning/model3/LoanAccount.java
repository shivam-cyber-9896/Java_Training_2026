package com.shivam.monocept.interfacelearning.model3;

public class LoanAccount implements AccountOperation {

    private static long counter = 909090L;

    private final long AccountNumber;
    private String accountName;
    private double LoanAmount;

    
    public LoanAccount(String name, String loanAmount, double annualPercentage, double year) {
        this.AccountNumber = ++counter;
        this.accountName = name;

        double principal = Double.parseDouble(loanAmount);

        double interest = (principal * annualPercentage * year) / 100;

        this.LoanAmount = principal + interest;
    }

    @Override
    public void deposit(String balance) {

        double amount = Double.parseDouble(balance);

        if (amount <= 0) {
            System.out.println("Invalid Deposit Amount!");
            return;
        }


        if (amount > LoanAmount) {
            System.out.println("Loan fully paid.");
            double extra = amount - LoanAmount;
            LoanAmount = 0;
            System.out.println("Extra amount returned: " + extra);
        } 
            LoanAmount -= amount;
            System.out.println("Payment successful.");
            System.out.println("Remaining Loan Amount: " + LoanAmount);
        
    }

    @Override
    public void withDrow(String amount) {
        System.out.println("Withdraw not Possible in Loan Account");
    }

    @Override
    public void checkBalance() {
        System.out.println("Account Number: " + AccountNumber);
        System.out.println("Account Holder: " + accountName);
        System.out.println("Remaining Loan Amount: " + LoanAmount);
    }
}