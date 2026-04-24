package com.shivam.monocept.institute.model;


public class Registration {
    @Override
	public String toString() {
		return "Registration [regId=" + regId + ", studentId=" + studentId + ", courseName=" + courseName
				+ ", feesPaid=" + feesPaid + "]";
	}

	private int regId;
    private int studentId;
    private String courseName;
    private double feesPaid;

    public Registration() {}

    public Registration(int regId, int studentId, String courseName, double feesPaid) {
        this.regId = regId;
        this.studentId = studentId;
        this.courseName = courseName;
        this.feesPaid = feesPaid;
    }

    public int getRegId() {
        return regId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }
}