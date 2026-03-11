package com.shivam.monocept.inputoutputstream.model1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {
String data;
public WriteInFile(String data ) {
	this.data=data;
 try {
	writeData();
} catch (IOException e) {
	e.printStackTrace();
}
}
private void writeData() throws IOException {
	FileWriter writer = new FileWriter("data.txt");
	writer.write(data);
	 writer.close();
     System.out.println("Data Written Successfully");
     showdata();
}
private void showdata() throws IOException{
	 BufferedReader br = new BufferedReader(new FileReader("data.txt"));

     String line;

     while ((line = br.readLine()) != null) {
         System.out.println(line);
     }

     br.close();
	
}
}
