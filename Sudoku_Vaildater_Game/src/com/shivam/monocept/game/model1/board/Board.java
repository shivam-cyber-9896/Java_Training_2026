package com.shivam.monocept.game.model1.board;


public class Board {

    private int[][] grid = new int[9][9];

    public int[][] getGrid() {
        return grid;
    }

    public void setValue(int row,int col,int value) {
        grid[row][col] = value;
    }

    public int getValue(int row,int col) {
        return grid[row][col];
    }
}