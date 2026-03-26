package com.shivam.monocept.collectionassingment.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shivam.monocept.collectionassingment.model3.Movie;

public class MovieTest {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Whats the No of Movie  do you want to sortBy Latest realse");
		int i=scanner.nextInt();
		while(i<=1)
		{
			System.out.println("Enter a vaild no of above 1");
			 i=scanner.nextInt();
			 
		}
		scanner.nextLine();
		int n=0;
		List<Movie> Type=new ArrayList();
		while(n<i)
		{
			System.out.println("Enter a Title");
			String name=scanner.nextLine();
			System.out.println("Enter a Year");
			int year =scanner.nextInt();
			scanner.nextLine();
			Type.add(new Movie(name,year));
			n++;
		}
		Type.sort(new Movie());
		for(Movie m:Type)
		{
			System.out.println(m);
		}
	}
}
