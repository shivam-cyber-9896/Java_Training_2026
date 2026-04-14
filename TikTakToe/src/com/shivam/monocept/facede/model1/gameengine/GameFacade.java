package com.shivam.monocept.facede.model1.gameengine;

import java.util.Scanner;

public class GameFacade {

    

    

    public void startGame() {
    	Scanner scanner=new Scanner(System.in);
    	String stringInput=null;
    	  int choice=0;
          do {
        	  System.out.println("Welcome to the Tik tac toe");
        	  System.out.println("1. Play games");
        	  System.out.println("2. Show Rules");
        	  System.out.println("3 . Exit");
        	   stringInput=scanner.nextLine();
        	   if(stringInput.matches("^[123]$"))
        		   choice=Integer.parseInt(stringInput);
        	
			  switch(choice) {
			  
        		  case 1:
        			  GameEngine engine = new GameEngine();
        			  engine.start();
        			  break;
        		  case 2:
        			  Rules.showRules();
        			  break;
        		  case 3:
        			  System.out.println("System is exiting Bye");
        			  break;
        		  default:
        				  System.out.println("Please enter a vaild choice");
          }		  
          }
          while(choice!=3);
       
    }
}