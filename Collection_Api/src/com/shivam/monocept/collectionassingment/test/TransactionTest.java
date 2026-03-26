package com.shivam.monocept.collectionassingment.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shivam.monocept.collectionassingment.model5.TransactionSort;

public class TransactionTest {
	public static void main(String[] argus) {
	Scanner scanner= new Scanner(System.in);
	System.out.println("How many Transaction you want to create");
	int i=scanner.nextInt();
	while(i<=1)
	{
		System.out.println("Enter a vaild no of above 1");
		 i=scanner.nextInt();
		 
	}
	scanner.nextLine();
	int n=0;
	List<TransactionSort> transaction=new ArrayList();
	while(n<i)
	{
		
		System.out.println("Enter a Trqansaction id");
		int id=scanner.nextInt();
		System.out.println("Enter Price");
		double price =scanner.nextDouble();
		transaction.add(new TransactionSort(id,price));
		n++;
		
	}
	transaction.sort(new TransactionSort());
	for(TransactionSort t:transaction)
	{
		System.out.println(t);
	}
	}
}
