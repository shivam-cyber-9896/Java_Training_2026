package com.shivam.monocept.encapsulation.model1;

public class InsuranceClaim {

    private static long counter = 1000;

    private final long claimId;
    private String policyNumber;
    private final double claimAmount;
    private double approvedAmount;
    private ClaimStatus claimStatus;

    public InsuranceClaim(String policyNumber, double claimAmount) {

        this.claimId = ++counter;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimStatus = ClaimStatus.FILED;   // Initial state
    }

    public long getClaimId() {
        return claimId;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    // Approve Claim
    public void approveClaim(double amount) {

        if (claimStatus == ClaimStatus.FILED) {

            if (amount >= 0 && amount <= claimAmount) {

                approvedAmount = amount - (amount * 10) / 100; // 10% deduction
                claimStatus = ClaimStatus.APPROVED;
                System.out.println("Claim Approved Successfully!");

            } else {
                System.out.println("Invalid Approved Amount!");
            }

        } else {
            System.out.println("Only FILED claim can be approved.");
        }
    }

    // Reject Claim
    public void rejectClaim() {

        if (claimStatus == ClaimStatus.FILED) {
            claimStatus = ClaimStatus.REJECTED;
            System.out.println("Claim Rejected!");
        } else {
            System.out.println("Only FILED claim can be rejected.");
        }
    }

    // Settle Claim
    public void settleClaim() {

        if (claimStatus == ClaimStatus.APPROVED || 
            claimStatus == ClaimStatus.REJECTED) {

            claimStatus = ClaimStatus.SETTLED;
            System.out.println("Claim Settled Successfully!");

        } else {
            System.out.println("Cannot settle at this stage.");
        }
    }
}
