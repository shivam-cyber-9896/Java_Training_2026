package com.shivam.monocept.cources.model1;

public class ScholarshipStudent extends CourceRegester {
double percentageOff;
	public ScholarshipStudent(String name, String courceName, double fees,double percentageOff) {
		super(name, courceName, fees);
		this.percentageOff=percentageOff;
	}
	
	@Override
	public void showDetail() {
		System.out.println("_________Scholarship Student detail__________");
		System.out.println("  Name :"+name);
		System.out.println("  CourceTaken : "+courceName);
		TotalFees();
	}

	@Override
	public void TotalFees() {
		double ActualFees= fees*percentageOff/100;	
		System.out.println("Total Fees of Student after waiffing off a"+(fees-ActualFees));
	}
	

}
