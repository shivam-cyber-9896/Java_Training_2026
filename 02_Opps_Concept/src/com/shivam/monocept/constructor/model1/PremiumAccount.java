package com.shivam.monocept.constructor.model1;



public class PremiumAccount extends BankAccount {

    private double bonusAmount;

    public PremiumAccount(long accountNumber, String accountHolderName,
                          double balance, double bonusAmount) {

        super(accountHolderName, balance);

        if (bonusAmount < 0) {
            this.bonusAmount = 0;
        } else {
            this.bonusAmount = bonusAmount;
            this.balance += bonusAmount;
        }
    }

    public double getBonusAmount() {
        return bonusAmount;
    }
}

