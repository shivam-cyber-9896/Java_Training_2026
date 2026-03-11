package com.shivam.monocept.miniproject.model1;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class Start {
	Scanner scanner= new Scanner(System.in);
	public void startGame() {
	  System.out.println("Choose your Option to play");	
	  System.out.println( "Press 1 for Computer Vs Player");
	  System.out.println("Press 2 for  Player Vs Player ");
	  String choice=scanner.nextLine();
	  while (choice == null|| choice.trim().isBlank() || !choice.trim().matches("^[12]$")) {
		    System.out.print("Press 1 or 2: ");
		    choice = scanner.nextLine();
		}
	  int i=Integer.parseInt(choice);
	  if(i==2) {
		  System.out.println("You are Choseing Player Vs Player");
		 PlayPvsP(); }
	  System.out.println("You Chose Computer Vs Player");
	  playAi();
		  
	}
	
	void playAi() {
		StartGameAi start= new StartGameAi();
		start.start();
	}
	void PlayPvsP() {
		StartGame start= new StartGame();
		start.start();
	}
	
}
