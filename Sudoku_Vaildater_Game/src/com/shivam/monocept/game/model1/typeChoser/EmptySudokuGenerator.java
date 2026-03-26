package com.shivam.monocept.game.model1.typeChoser;

import com.shivam.monocept.game.model1.board.Board;

public class EmptySudokuGenerator {

    public void generateEmptyBoard(Board board) {

        int[][] grid = board.getGrid();

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {

                grid[i][j]=0;

            }
        }
    }
}