package com.shivam.monocept.collectionassingment.model5;

import java.util.Comparator;

public class TransactionSort implements Comparator<TransactionSort> {

	private int id;
	private double amount;
	
	public int getId() {
		return id;
	}

	
	public double getAmount() {
		return amount;
	}

	
	public TransactionSort(int id, double amount) {
		
		this.id = id;
		this.amount = amount;
	}


	public TransactionSort() {
		
	}


	@Override
	public String toString() {
		return "TransactionSort [id=" + id + ", amount=" + amount + "]";
	}


	@Override
	public int compare(TransactionSort o1, TransactionSort o2) {
		int compare=Double.compare(o2.getAmount(),o1.getAmount());
		if(compare==0)
		   return o1.getId()-o2.getId();
		return compare;
	}

}
