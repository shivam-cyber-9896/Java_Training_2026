package com.shivam.monocept.abstractAssingment.model1;




public abstract class Loan implements LoanEligibility {

    protected   long loanId;
    protected String borrowerName;
    protected double principalAmount;
    protected double interestRate;
        private static long counter=110236;
        static {
            System.out.println("===== Digital Loan Processing System Started =====");
        }
    public Loan(String borrowerName, double principalAmount, double interestRate) throws InvalidLoanException {
           

        if (principalAmount <= 0)
            throw new InvalidLoanException("Loan amount must be positive");

        if (interestRate <= 0)
            throw new InvalidLoanException("Interest rate must be positive");

          loanId = ++counter;
        this.borrowerName = borrowerName;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
    }
   
    public abstract double calculateRepayment();

    public abstract void displayLoanDetails(); 
}
