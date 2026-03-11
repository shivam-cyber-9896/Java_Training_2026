package com.shivam.monocept.inputoutputstream.test;

import java.io.IOException;
import java.util.Scanner;

import com.shivam.monocept.inputoutputstream.model1.DeleteInFileExample;

public class DeleteFileTest {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String word;
		System.out.println("Enter a Word doyou want to Delete");
		word=scanner.next();
		DeleteInFileExample Delete =new DeleteInFileExample();
		try {
			Delete.Delete(word);
		} catch (IOException e) {
			System.out.println("Exception handlle suceesfully"+e);
			e.printStackTrace();
		}

	}

}
