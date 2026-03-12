package com.shivam.monocept.abstractAssingment.model2;



public abstract class HospitalService implements ServiceValidation {

    protected long serviceId;
    protected String patientName;
    protected double consultationFee;

    private static long counter = 8011;

    static {
     
        System.out.println("Hospital Appointment System");
        
    }

    public HospitalService(String patientName, double consultationFee)
            throws InvalidServiceException {

        if (consultationFee <= 0)
            throw new InvalidServiceException("Consultation fee must be positive");

        this.serviceId = ++counter;
        this.patientName = patientName;
        this.consultationFee = consultationFee;

        System.out.println("HospitalService Constructor Executed");
    }

    public abstract double calculateTotalFee();

    public abstract void displayDetails();
}