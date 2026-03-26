package com.shivam.monocept.game.model1.vaildator;

import com.shivam.monocept.game.model1.board.Board;

public class RowAndColumnChecker {

    public boolean checkRow(Board board,int row,int num) {

        int[][] grid = board.getGrid();

        for(int i=0;i<9;i++) {

            if(grid[row][i]==num)
                return false;

        }

        return true;
    }
    
    public boolean checkColumn(Board board,int col,int num) {

        int[][] grid = board.getGrid();

        for(int i=0;i<9;i++) {

            if(grid[i][col]==num)
                return false;

        }

        return true;
    }
}