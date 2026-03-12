package com.shivam.monocept.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGusser  {
    public void Start() {
        try (Scanner scanner = new Scanner(System.in)) {
			int lowerBound = 1;
			int upperBound = 100;

			
			int numberToGuess = (int) (Math.random() * 100);
			int userGuess = 0;
			int attempts = 0;

			System.out.println("Welcome to the Number Guessing Game!");
			System.out.println("I have picked a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");

			while (userGuess != numberToGuess) {
			    System.out.print("Enter your guess: ");
			    if (!scanner.hasNextInt()||userGuess<=0||userGuess>100) {
			        System.out.println("Please enter a valid number.");
			        scanner.next();
			        continue;
			    }

			    userGuess = scanner.nextInt();
			    attempts++;

			    if (userGuess < numberToGuess) {
			        System.out.println("Too low! Try again.");
			    }  
			    if (userGuess > numberToGuess) {
			        System.out.println("Too high! Try again.");
			    } 
			    if (userGuess == numberToGuess){
			        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
			    }
			}
		}
        catch(InputMismatchException e) {
        System.out.println("Plese give a Vaild input");	
        }
      catch(Exception e) {
    	  System.out.println("Unexcpected Exception"+e);
      }
        
    }
}



