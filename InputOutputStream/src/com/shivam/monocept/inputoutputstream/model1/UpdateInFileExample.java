package com.shivam.monocept.inputoutputstream.model1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateInFileExample {

 public void update(String Name,String updatedName ) throws IOException {
	 BufferedReader br = new BufferedReader(new FileReader("student.txt"));
     BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));

     String line;

     while((line = br.readLine()) != null){

         if(line.contains(Name)){
             line =updatedName ;
         }

         bw.write(line);
         bw.newLine();
     }

     br.close();
     bw.close();

     System.out.println("Record Updated");
   showdata();  
}
 void showdata() throws IOException{
	 BufferedReader br = new BufferedReader(new FileReader("temp.txt"));

    String line;

    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }

    br.close();
	
}
}
