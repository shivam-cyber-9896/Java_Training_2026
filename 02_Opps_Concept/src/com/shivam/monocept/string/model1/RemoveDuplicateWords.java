package com.shivam.monocept.string.model1;

public class RemoveDuplicateWords {
	 String sentence ;
    
public RemoveDuplicateWords( String sentence)
{this.sentence=sentence;
removeWords();
	}

private void removeWords() {
	String[] words = sentence.split(" ");

	String result = words[0];
	 for (int i = 1; i < words.length; i++) {
         if (!words[i].equals(words[i - 1])) {
             result = result + " " + words[i];
         }
     }

     System.out.println(result);
 }
	
}



