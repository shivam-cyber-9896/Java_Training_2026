package com.shivam.monocept.string.model1;

public class WordFrequencyCounter {
String Sentance;
String[] split;
int[] count;
public WordFrequencyCounter(String Sentance){
	this.Sentance=Sentance;
}
public void counter() {
	split=Sentance.split(" ");
	 count = new int[split.length];
	 for(int i=0;i<split.length;i++) {
         count[i] = 1;
		 for(int j=0;j<split.length;j++) {
			 if(split[i].equals(split[j]))
			 {
				 count[i]=count[i]+1;
				
			 }
		 }
		 
	 }
	  print();
}
private void print() {
	for(int i=0;i<split.length;i++)
	{   if (count[i] != -1) {
        System.out.println(split[i] + " : " + count[i]);
    }
	}
}
}
