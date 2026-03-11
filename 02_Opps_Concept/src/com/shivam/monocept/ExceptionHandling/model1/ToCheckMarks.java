package com.shivam.monocept.ExceptionHandling.model1;

public class ToCheckMarks {
	public static void CheckMarks(Double Marks) {
		if(Marks<0||Marks>100)
			throw new IllegalArgumentException("Enter A Vaild Marks");
		System.out.println("Vaild Marks");
	}

}
