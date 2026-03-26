package com.shivam.monocept.game.model1.vaildator;

import com.shivam.monocept.game.model1.board.Board;

public class BoxChecker {

    public boolean checkBox(Board board,int row,int col,int num) {

        int[][] grid = board.getGrid();

        int startRow = row - row%3;
        int startCol = col - col%3;

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {

                if(grid[startRow+i][startCol+j]==num)
                    return false;

            }
        }

        return true;
    }
}