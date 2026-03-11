package com.shivam.monocept.constructor.model1;


public class CorporateClaim extends InsuranceClaim {

    private final double processingFee;

    public CorporateClaim(String policyNumber,
                          double claimAmount,
                          double processingFee) {

        super(policyNumber, claimAmount);   // Parent constructor called first

        if (processingFee < 0) {
            this.processingFee = 0;
        } else {
            this.processingFee = processingFee;
        }
    }

    public double getProcessingFee() {
        return processingFee;
    }
}
