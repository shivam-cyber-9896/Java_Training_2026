package com.shivam.monocept.game.model1.board;

public class BoardPrinter {

    public void printBoard(Board board) {

        int[][] grid = board.getGrid();

        for(int i=0;i<9;i++) {

            for(int j=0;j<9;j++) {

                System.out.print(grid[i][j] + " ");

            }

            System.out.println();
        }
    }
}