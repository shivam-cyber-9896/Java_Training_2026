package com.shivam.monocept.collectionassingment.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shivam.monocept.collectionassingment.model1.CandidateComparator;
import com.shivam.monocept.collectionassingment.model1.CandidatesComparable;

public class CandidatesComparableTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Whats the No of student do you want to sort");
		int i=scanner.nextInt();
		while(i<=1)
		{
			System.out.println("Enter a vaild no of above 1");
			 i=scanner.nextInt();
			 
		}
		scanner.nextLine();
		int n=0;
		List<CandidatesComparable> candidates= new ArrayList();
		while(n<i)
		{
			System.out.println("Enter a Name");
			String name=scanner.nextLine();
			System.out.println("Enter a Age");
			int age =scanner.nextInt();
			scanner.nextLine();

			candidates.add(new CandidatesComparable(name,age) );
			n++;
		}
		candidates.sort(new CandidateComparator());
	       
		for(CandidatesComparable c : candidates)
	        {
	            System.out.println(c);
	        }
		
		
	}

}
