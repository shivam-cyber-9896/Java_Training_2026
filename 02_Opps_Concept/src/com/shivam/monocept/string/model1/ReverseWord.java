package com.shivam.monocept.string.model1;

public class ReverseWord {

	        String sentence;
	       public ReverseWord (String sentence){
	        	this.sentence=sentence;
	        	reverse();
	        }
	        
	        private void reverse() {
	        	String[] words = sentence.split(" ");

		        String result = "";

	        for (String word : words) {

	            String rev = "";

	            for (int i = word.length() - 1; i >= 0; i--) {
	                rev += word.charAt(i);
	            }

	            result += rev + " ";
	        }

	        System.out.println(result.trim());
	    }
	}

