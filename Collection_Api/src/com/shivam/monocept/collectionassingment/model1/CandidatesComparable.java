package com.shivam.monocept.collectionassingment.model1;

import java.util.Objects;

public class CandidatesComparable implements Comparable<CandidatesComparable> {
	String Name;
	int age;
	public CandidatesComparable(String Name ,int age)
	{
		this.age=age;
		this.Name=Name;
	}
	public String getName() {
		return Name;
	}
	
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "CandidatesComparable [Name=" + Name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(CandidatesComparable c)  {
        return this.age - c.age;   
	}
	@Override
	public int hashCode() {
		return Objects.hash(Name, age);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CandidatesComparable))
			return false;
		CandidatesComparable other = (CandidatesComparable) obj;
		return Objects.equals(Name, other.Name) && age == other.age;
	}
	
}
