package com.shivam.monocept.inputoutputstream.test;

import java.util.Scanner;

import com.shivam.monocept.inputoutputstream.model1.WriteInFile;

public class WriteInFiletest {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
	String data;
	System.out.println("Enter your data do you wantto store in file");
      data=scanner.nextLine();
      WriteInFile writer=new WriteInFile(data);
	}

}
