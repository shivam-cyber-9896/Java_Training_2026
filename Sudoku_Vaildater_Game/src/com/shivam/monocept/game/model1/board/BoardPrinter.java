package com.shivam.monocept.game.model1.board;

public class BoardPrinter {

    private static final int SIZE = 9;

    public void printBoard(Board board) {

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                System.out.print(board.getValue(i, j) + " ");
            }

            System.out.println();
        }
    }
}