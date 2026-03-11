package com.shivam.monocept.encapsulation.model;

public class InsuranceClaim {

    private static long counter = 1000;

    private final long claimId;
    private String policyNumber;
    private final double claimAmount;
    private double approvedAmount;
    private String claimStatus;

    public InsuranceClaim(String policyNumber, double claimAmount) {

        if (claimAmount < 0) {
            throw new IllegalArgumentException("Claim amount cannot be negative");
        }

        this.claimId = ++counter;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimStatus = "FILED";   // Initial state
    }

    public long getClaimId() {
        return claimId;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    // Approve
    public void approveClaim(double amount) {

        if (!claimStatus.equals("FILED")) {
            throw new IllegalStateException("Only FILED claim can be approved");
        }

        if (amount < 0 || amount > claimAmount) {
            throw new IllegalArgumentException("Invalid approved amount");
        }

        approvedAmount = amount;
        claimStatus = "APPROVED";
    }

    // Reject
    public void rejectClaim() {

        if (!claimStatus.equals("FILED")) {
            throw new IllegalStateException("Only FILED claim can be rejected");
        }

        claimStatus = "REJECTED";
    }

    // Settle
    public void settleClaim() {

        if (!claimStatus.equals("APPROVED") && 
            !claimStatus.equals("REJECTED")) {
            throw new IllegalStateException("Cannot settle at this stage");
        }

        claimStatus = "SETTLED";
    }
}
