package com.shivam.monocept.inputoutputstream.model1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteInFileExample {
	public void Delete(String Name) throws IOException {
		 BufferedReader br = new BufferedReader(new FileReader("student.txt"));
	     BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));

	     String line;

	  

	    	  while((line = br.readLine()) != null){

	              if(!line.contains(Name)){
	                  bw.write(line);
	                  bw.newLine();
	              }
	     
	    	  }
	     br.close();
	     bw.close();

	     System.out.println("Record Deleted");
	    showdata();
	
	}
    private	 void showdata() throws IOException{
		 BufferedReader br = new BufferedReader(new FileReader("temp.txt"));

	    String line;

	    while ((line = br.readLine()) != null) {
	        System.out.println(line);
	    }

	    br.close();
		
	}
}
