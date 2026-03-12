package com.shivam.monocept.Game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {

     public void Start() {

        try (Scanner scanner = new Scanner(System.in)) {

            Random random = new Random();

            int playerScore = 0;
            int winningScore = 20;

            System.out.println("Welcome to Pig Dice Game!");
            System.out.println("Reach " + winningScore + " points to win.");

            while (playerScore < winningScore) {

                System.out.println("\nCurrent Score: " + playerScore);

                int turnTotal = 0;
                boolean turnOver = false;

                while (!turnOver) {

                    System.out.print("Roll or hold? (r/h): ");
                    String choice = scanner.next();

                    if (!choice.equalsIgnoreCase("r") && !choice.equalsIgnoreCase("h")) {
                        System.out.println("Invalid choice! Type 'r' to roll or 'h' to hold.");
                        continue;
                    }

                    if (choice.equalsIgnoreCase("r")) {

                        int roll = random.nextInt(6) + 1;
                        System.out.println("You rolled: " + roll);

                        if (roll == 1) {
                            System.out.println("Oops! You rolled 1. Turn over, no points added.");
                            turnTotal = 0;
                            turnOver = true;
                            continue;
                        }

                        turnTotal += roll;
                        System.out.println("Turn total: " + turnTotal);
                        continue;
                    }

                    playerScore += turnTotal;
                    System.out.println("You hold. Total score: " + playerScore);
                    turnOver = true;
                }
            }

            System.out.println("\n Congratulations! You reached " + playerScore + " Score");

        } catch (InputMismatchException e) {

            System.out.println("Please give a valid input.");

        } catch (Exception e) {

            System.out.println("Unexpected Exception: " + e);
        }
    }
}