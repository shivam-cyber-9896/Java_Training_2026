package com.shivam.monocept.student.model1;

import java.util.ArrayList;
import java.util.List;

public  abstract class Student {
	protected String name;
	protected long rollno;
	protected String cource;
	protected int totalSubject;
	List<Integer> percentage=new ArrayList<Integer>();
	
	Student(String name,long rollno,String cource,int totalSubject ,List<Integer> percentage)
	{this.name=name;
	this.rollno=rollno;
	this.cource=cource;
	this.totalSubject=totalSubject;
	this.percentage=percentage;
		
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + ", cource=" + cource + ", totalSubject=" + totalSubject
				+ ", percentage=" + percentage + "]";
	}

	public abstract void CalculatePercentage();

}
