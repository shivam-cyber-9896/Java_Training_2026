package com.shivam.monocept.abstractAssingment.model1;

public class EducationLoan extends Loan implements LoanEligibility {
	int years;

	public EducationLoan(String name, double amount, double rate, int years) throws InvalidLoanException {
		
		super(name, amount, rate);
		this.years = years;
		
	}

	@Override
	public double calculateRepayment() {
		return principalAmount + (principalAmount * interestRate * years / 100) - 1000;
	}

	@Override
	public boolean checkEligibility(double income) {
		return income > 20000;
	}

	@Override
	public void displayLoanDetails() {
		System.out.println("Home Lone details are");
	       System.out.println(" Lone Issue Name "+borrowerName);
	       System.out.println("Principal"+principalAmount);
	       System.out.println(" Rate of Interset"+interestRate);
	       System.out.println("total No years"+years);
	       System.out.println("Total amount to Paid"+calculateRepayment());
	       int mounts=years*12;
	       System.out.println("Actual montaly installment"+(calculateRepayment()/mounts));
	}
}