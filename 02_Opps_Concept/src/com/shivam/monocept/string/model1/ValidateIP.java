package com.shivam.monocept.string.model1;
import java.util.Scanner;

public class ValidateIP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP Address: ");
        String ip = sc.nextLine();

        String[] parts = ip.split("\\.");

        boolean valid = true;

        if (parts.length != 4) {
            valid = false;
        } 
        else {

            for (String part : parts) {

                try {
                    int num = Integer.parseInt(part);

                    if (num < 0 || num > 255) {
                        valid = false;
                        break;
                    }

                } catch (NumberFormatException e) {
                    valid = false;
                    break;
                }
            }
        }

        if (valid)
            System.out.println("Valid IPv4 Address");
        else
            System.out.println("Invalid IPv4 Address");

        sc.close();
    }
}