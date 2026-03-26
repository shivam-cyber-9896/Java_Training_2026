package com.shivam.monocept.student.model1;

import java.util.Iterator;
import java.util.List;

public class UndergraguateStudent extends Student {
           
	@Override
	public String toString() {
		return "UndergraguateStudent [name=" + name + ", rollno=" + rollno + ", cource=" + cource + ", totalSubject="
				+ totalSubject + ", percentage=" + percentage + "]";
	}

	UndergraguateStudent(String name, long rollno, String cource, int totalSubject, List<Integer> percentage) {
		super(name, rollno, cource, totalSubject, percentage);
		
	}

	@Override
	public void CalculatePercentage() {
		Iterator<Integer> Calculation =percentage.iterator();
		int sum=0;
		while(Calculation.hasNext())
		{
			int O = Calculation.next(); 
			sum=O+sum;
			
	    
		}
		int length=percentage.size();
		System.out.println( "Percentage is ="+(sum/length)+"%");
	}

}
