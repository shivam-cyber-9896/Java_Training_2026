package com.shivam.monocept.cources.model1;

public abstract class CourceRegester {
	protected  final long rollNo;
	protected  final String name;
	protected  final String courceName;
	protected double fees;
	private static long counter=1234;
	CourceRegester(String name,String courceName,double fees){
		this.rollNo=counter++;
		this.courceName=courceName;
		this.name=name;
		this.fees=fees;
	}
public abstract void showDetail();
public abstract void TotalFees();
	
	
}
