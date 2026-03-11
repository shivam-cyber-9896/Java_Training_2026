package com.shivam.monocept.constructor.model1;


public class InsuranceClaim {

    private static long counter = 1000;

    private final long claimId;
    private final String policyNumber;
    private final double claimAmount;
    private ClaimStatus status;
    private double approvedAmount;

    
    public InsuranceClaim(String policyNumber, double claimAmount) {

        this.claimId = ++counter;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;

        this.status = ClaimStatus.FILED;   // Always start as FILED
        this.approvedAmount = 0;           // Initially 0
    }

    public long getClaimId() {
        return claimId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    // Controlled approval method
    public void approveClaim(double amount) {

        if (amount <= claimAmount && amount >= 0) {
            this.approvedAmount = amount-(amount/10);
            this.status = ClaimStatus.APPROVED;
        }
    }

    public static long getCounter() {
		return counter;
	}

	public static void setCounter(long counter) {
		InsuranceClaim.counter = counter;
	}

	public void setStatus(ClaimStatus status) {
		this.status = status;
	}

	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public void rejectClaim() {
        this.status = ClaimStatus.REJECTED;
    }
}
