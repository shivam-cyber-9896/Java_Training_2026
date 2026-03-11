package com.shivam.monocept.model1;

import java.util.Scanner;

public class TicTacToeInt2D {

    static int[][] board = new int[3][3];
    static final int PLAYER = 1; // X
    static final int AI = 2;     // O

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        printBoard();

        while (true) {

            // Player Move
            playerMove(sc);
            printBoard();

            if (isWinner(PLAYER)) {
                System.out.println("🎉 Player X wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a Draw!");
                break;
            }

            // AI Move
            aiMove();
            System.out.println("AI played:");
            printBoard();

            if (isWinner(AI)) {
                System.out.println("🤖 AI wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a Draw!");
                break;
            }
        }

        sc.close();
    }

    // Print board with numbers
    static void printBoard() {
        int count = 1;
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == 0)
                    System.out.print(" " + count + " ");
                else
                    System.out.print(" " + getSymbol(board[i][j]) + " ");

                if (j < 2) System.out.print("|");

                count++;
            }
            if (i < 2) System.out.println("\n---+---+---");
        }
        System.out.println("\n");
    }

    static String getSymbol(int value) {
        return (value == PLAYER) ? "X" : "O";
    }

    // Player Move using 1–9 input
    static void playerMove(Scanner sc) {

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
                System.out.println("Invalid position! Try again.");
            }
        }
    }

    // AI Move
    static void aiMove() {

        if (tryMove(AI)) return;       // Try to win
        if (tryMove(PLAYER)) return;   // Block player

        // Otherwise first empty
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == 0) {
                    board[i][j] = AI;
                    return;
                }
    }

    static boolean tryMove(int symbol) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == 0) {

                    board[i][j] = symbol;

                    if (isWinner(symbol)) {
                        board[i][j] = AI;
                        return true;
                    }

                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    static boolean isWinner(int symbol) {

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

    static boolean isBoardFull() {
        for (int[] row : board)
            for (int cell : row)
                if (cell == 0)
                    return false;
        return true;
    }
}