package com.shivam.monocept._2D_arrays;

import java.util.Scanner;

public class TwoDemsionalShow  {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = 3;
        int cols = 4;

        int[][] arr = new int[rows][cols];

        // Taking input
        System.out.println("Enter elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Displaying array
        System.out.println("Matrix is:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}



