package com.shivam.monocept.game.model1.board;

public class Board {

    private static final int SIZE = 9;

    private int[][] grid;
    private boolean[][] fixed;

    public Board() {
        grid = new int[SIZE][SIZE];
        fixed = new boolean[SIZE][SIZE];
    }

   

    public int getValue(int row, int col) {
        validatePosition(row, col);
        return grid[row][col];
    }

    public void setValue(int row, int col, int value) {
        validatePosition(row, col);
        validateValue(value);

        if (fixed[row][col]) {
            throw new IllegalStateException("Cannot modify fixed cell!");
        }

        grid[row][col] = value;
    }

    
    public void setFixedValue(int row, int col, int value) {
        validatePosition(row, col);
        validateValue(value);

        grid[row][col] = value;
        fixed[row][col] = true;
    }

    public boolean isFixed(int row, int col) {
        validatePosition(row, col);
        return fixed[row][col];
    }

    public boolean isEmpty(int row, int col) {
        return getValue(row, col) == 0;
    }

    public void clearCell(int row, int col) {
        validatePosition(row, col);

        if (fixed[row][col]) {
            throw new IllegalStateException("Cannot clear fixed cell!");
        }

        grid[row][col] = 0;
    }

    
    private void validatePosition(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IllegalArgumentException("Invalid position");
        }
    }

    private void validateValue(int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("Invalid value");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (grid[i][j] == 0) {  
                    return false;
                }
            }
        }
        return true;
    }
}