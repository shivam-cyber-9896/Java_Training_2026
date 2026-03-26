package com.shivam.monocept.predicate.test;

import java.util.function.Predicate;

public class oddNumberChecker {
public static void main(String[] argus) {
Predicate<Integer> isOdd = x -> x%2!=0;	
for(int i=1;i<=10;i++)
{
System.out.println("Checking number is odd  :"+i+"  "+isOdd.test(i));	


}
}
}
