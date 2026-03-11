package com.shivam.monocept.Game;

import java.util.Scanner;

public class NumberGusser  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       

        int lowerBound = 1;
        int upperBound = 100;

        
        int numberToGuess = (int) (Math.random() * 100);
        int userGuess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // discard invalid input
                continue;
            }

            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }

        scanner.close();
    }
}



