package com.shivam.monocept.cources.model1;

public class RegularStudent extends CourceRegester{

	public RegularStudent(String name, String courceName, double fees) {
		super(name, courceName, fees);
		
	}

	public void showDetail() {
		System.out.println("_________Regular Student detail__________");
		System.out.println("  Name :"+name);
		System.out.println("  CourceTaken : "+courceName);
		TotalFees();
		
	}

	public void TotalFees() {
		double actualfees=fees*0.10;
		System.out.println("Total Fees  Student after Adding Tax a"+(fees+actualfees));
		
	}

}
