package com.shivam.monocept.inputoutputstream.model1;

import java.io.*;

public class ReadFileExample {
	
	 
		public static void main(String[] args) {
try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Shivam\\Desktop\\Java_Training\\InputOutputStream\\src\\com\\shivam\\monocept\\inputoutputstream\\model1\\Abc.txt"));

	        String line;

	        while((line = br.readLine()) != null){
	            System.out.println(line);
	        }

	        br.close();
	    
	}
catch(IOException e) {
	System.out.println("Exception  is"+e);
}
}
}