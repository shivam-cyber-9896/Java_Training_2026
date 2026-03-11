package com.shivam.monocept.model1;


import java.util.Random;
import java.util.Scanner;

public class ticktactoePvsC {

    private int[][] board = new int[3][3];
    private final int PLAYER = 1; 
    private final int AI = 2;     
   
    public void start() {

        Scanner scanner = new Scanner(System.in);
        printBoard();

        while (true) {

            playerMove(scanner);
            printBoard();

            if (isWinner(PLAYER)) {
                System.out.println("🎉 Player X Wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a Draw!");
                break;
            }

            aiMove();
            System.out.println("AI Played:");
            printBoard();

            if (isWinner(AI)) {
                System.out.println("🤖 AI Wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a Draw!");
                break;
            }
        }
    }

    
    private void printBoard() {

        int count = 1;
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == 0)
                    System.out.print(" " + count + " ");
                else if (board[i][j] == PLAYER)
                    System.out.print(" X ");
                else
                    System.out.print(" O ");

                if (j < 2) System.out.print("|");
                count++;
            }
            if (i < 2) System.out.println("\n---+---+---");
        }
        System.out.println("\n");
    }

   
    private void playerMove(Scanner sc) {

        int position;

        while (true) {
            System.out.print("Enter position (1-9): ");
            position = sc.nextInt();

            if (position >= 1 && position <= 9) {

                int row = (position - 1) / 3;
                int col = (position - 1) % 3;

                if (board[row][col] == 0) {
                    board[row][col] = PLAYER;
                    break;
                } else {
                    System.out.println("Position already taken!");
                }

            } else {
                System.out.println("Invalid position!");
            }
        }
    }

   
    private void aiMove() {

        Random random = new Random();
        int row, col;

        while (true) {
            row = random.nextInt(3); 
            col = random.nextInt(3);

            if (board[row][col] == 0) {
                board[row][col] = AI;
                break;
            }
        }
    }

    // Check Winner
    private boolean isWinner(int symbol) {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol)
                return true;

            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol)
                return true;
        }

        // Diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol)
            return true;

        return false;
    }

  
    private boolean isBoardFull() {

        for (int[] row : board)
            for (int cell : row)
                if (cell == 0)
                    return false;

        return true;
    }
}