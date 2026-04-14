package com.shivam.monocept.facede.model1.board;


public class BoardPrint {

    public void printBoard(Board board) {

        int[][] cells = board.getCells();
        int count = 1;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (cells[i][j] == 0)
                    System.out.print(" " + count + " ");
                else if (cells[i][j] == 1)
                    System.out.print(" X ");
                else
                    System.out.print(" O ");

                if (j < 2) System.out.print("|");
                count++;
            }

            if (i < 2) System.out.println("\n---+---+---");
        }
        System.out.println();
    }
}