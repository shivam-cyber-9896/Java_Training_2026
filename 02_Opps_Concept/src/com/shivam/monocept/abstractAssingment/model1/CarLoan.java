package com.shivam.monocept.abstractAssingment.model1;


public class CarLoan extends Loan implements LoanEligibility {
	int years;
    public CarLoan(String name, double amount, double rate,int years)
            throws InvalidLoanException {
        super(name, amount, rate);
        this.years=years;
       
    }

    
    public double calculateRepayment() {
        return principalAmount + (principalAmount * interestRate * years / 100) + 2000;
    }

    @Override
    public boolean checkEligibility(double income) {
        return income > 30000;
    }

	@Override
	public void displayLoanDetails() {
		System.out.println("Car Lone details are");
	       System.out.println(" Lone holder Name "+borrowerName);
	       System.out.println("Principal"+principalAmount);
	       System.out.println(" Rate of Interset"+interestRate);
	       System.out.println("total No years"+years);
	       System.out.println("Total amount to Paid"+calculateRepayment());
	       int mounts=years*12;
	       System.out.println("Actual montaly installment"+(calculateRepayment()/mounts));
		
	}
}