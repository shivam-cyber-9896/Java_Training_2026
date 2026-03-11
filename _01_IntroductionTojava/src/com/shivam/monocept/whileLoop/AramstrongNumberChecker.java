package com.shivam.monocept.whileLoop;

import java.util.Scanner;

public class AramstrongNumberChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = input.nextInt();
            if(number<10) {
            	System.out.println("plese enter a  is two digit");
            	return;
            }
        int original = number;
        int count = 0;
        int sum = 0;

        // Step 1: Count digits
        int temp = number;
        while (temp > 0) {
            temp = temp / 10;
            count++;
        }

        // Step 2: Calculate Armstrong sum
        temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, count);
            temp = temp / 10;
        }

        // Step 3: Compare
        if (sum == original) {
            System.out.println("It is an Armstrong number.");
        } else {
            System.out.println("It is NOT an Armstrong number.");
        }

        input.close();
    }
}
