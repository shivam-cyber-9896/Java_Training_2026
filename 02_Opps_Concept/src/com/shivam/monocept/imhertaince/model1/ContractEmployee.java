package com.shivam.monocept.imhertaince.model1;
//Contract Employee
public class ContractEmployee extends Employee {

 private double fixedAmount;
 private double tax;

 public ContractEmployee(String empId, String name, double fixedAmount, double tax) {
     super(empId, name);
     this.fixedAmount = fixedAmount;
     this.tax = tax;
 }

 @Override
 public double calculateSalary() {
     return fixedAmount - tax;
 }
}
