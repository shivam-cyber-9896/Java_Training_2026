package com.shivam.monocept.game.model1.board;

public class BoardFullChecker {

    public boolean isBoardFull(Board board) {

        int[][] grid = board.getGrid();

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {

                if(grid[i][j]==0) {
                    return false;
                }

            }
        }

        return true;
    }
}