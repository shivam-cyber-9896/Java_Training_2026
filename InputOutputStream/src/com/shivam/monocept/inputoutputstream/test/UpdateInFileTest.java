package com.shivam.monocept.inputoutputstream.test;

import java.io.IOException;
import java.util.Scanner;

import com.shivam.monocept.inputoutputstream.model1.UpdateInFileExample;

public class UpdateInFileTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
	String word;
	System.out.println("Enter a Word doyou want to update");
	word=scanner.next();
	System.out.println("Enter a update word");
	String updatedWord=scanner.next();
	UpdateInFileExample updater= new UpdateInFileExample();
	try {
		updater.update(word,updatedWord);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}

}
