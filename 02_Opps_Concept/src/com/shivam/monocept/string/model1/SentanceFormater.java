package com.shivam.monocept.string.model1;

public class SentanceFormater {
String Sentance;
 public SentanceFormater(String Sentance){
	this.Sentance=Sentance;
}
 public void Formatter(){
	 String[] split = Sentance.split(" ");
	 int last =split.length;
	 System.out.println("Total words in a Sentance "+(last));
	 System.out.println("First word   :"+split[0]);
	 System.out.println("Last  Word   :  "+split[last-1]);
 }
}
